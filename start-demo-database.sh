#!/usr/bin/env bash

yellow='\e[33m'
noColor='\e[0m'

projectDir=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
buildDir="$projectDir/quantumleap.build.tmp"

dockerImageName="postgres-quantum-leap-demo:latest"

createDockerfiles() {
	printf "${yellow}### Create Dockerfile ###${noColor}\n"

  local email="test@gmail.com"
  local userName="Test Test"

  mkdir -p "$buildDir"
	cp "$projectDir/quantumleap/core/src/main/resources/db/scripts/00_schema.sql" \
		"$buildDir/create-core-schema.sql" || exit 1
	cp "$projectDir/src/main/resources/db/scripts/00_schema.sql" \
		"$buildDir/create-demo-schema.sql" || exit 1
	cat <<- DBINIT > "$buildDir/init-db.sql" || exit 1
  INSERT INTO core.increment (module, version, file_name, created_at)
  VALUES ('core', 999, 'whatever', CURRENT_TIMESTAMP),
         ('admin', 999, 'whatever', CURRENT_TIMESTAMP);

  INSERT INTO core.role (name)
  VALUES ('ADMIN');

  INSERT INTO core.person (email, name, created_at)
  VALUES ('$email', '$userName', CURRENT_TIMESTAMP);

  INSERT INTO core.person_role (person_id, role_id)
  VALUES ((SELECT id FROM core.person WHERE email = '$email'),
          (SELECT id FROM core.role WHERE name = 'ADMIN'));
DBINIT

	cat <<- DOCKERFILE > "$buildDir/Dockerfile" || exit 1
	FROM postgres
	ENV POSTGRES_USER=quantumleap
	ENV POSTGRES_PASSWORD=quantumleap
	ENV POSTGRES_DB=quantumleap
	EXPOSE 5432
	COPY create-core-schema.sql /docker-entrypoint-initdb.d/00_create-core-schema.sql
	COPY create-demo-schema.sql /docker-entrypoint-initdb.d/01_create-demo-schema.sql
	COPY init-db.sql /docker-entrypoint-initdb.d/02_init-db.sql
DOCKERFILE
}

buildDockerImage() {
	printf "${yellow}### Build Docker image ###${noColor}\n"

	pushd "$buildDir" || exit 1
	docker build \
		--tag "$dockerImageName" \
		--file Dockerfile \
		. || exit 1
	popd || exit 1
}

runDocker() {
	printf "${yellow}### Run Docker ###${noColor}\n"

	docker run \
		--publish 65432:5432 \
		"$dockerImageName" || exit 1
}

createDockerfiles
buildDockerImage
runDocker
