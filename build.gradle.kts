plugins {
    id("com.github.vkuzel.Quantum-Leap-Gradle-Plugin")
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project("quantumleap:core"))
    implementation(project("quantumleap:admin"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
