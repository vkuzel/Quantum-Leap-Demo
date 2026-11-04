#!/usr/bin/env bash

yellow='\e[33m'
noColor='\e[0m'

projectDir=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
buildDir="$projectDir/quantumleap.build.tmp"

dockerImageName="postgres-quantum-leap-demo-test:latest"

createDockerfiles() {
	printf "${yellow}### Create Dockerfile ###${noColor}\n"

  mkdir -p "$buildDir"
	cp "$projectDir/quantumleap/core/src/main/resources/db/scripts/createDatabase.sql" \
		"$buildDir/create-database.sql" || exit 1

	cat <<- DOCKERFILE > "$buildDir/Dockerfile" || exit 1
	FROM postgres
	ENV POSTGRES_USER=quantumleap_test
	ENV POSTGRES_PASSWORD=quantumleap_test
	ENV POSTGRES_DB=quantumleap_test
	EXPOSE 5432
	COPY create-database.sql /docker-entrypoint-initdb.d/00_create-database.sql
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
