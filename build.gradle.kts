plugins {
    id("com.github.vkuzel.Quantum-Leap-Gradle-Plugin") version "2.3.0-2"
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project("core"))
    implementation(project("admin"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
