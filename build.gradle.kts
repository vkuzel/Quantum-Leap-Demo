buildscript {
    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath("cz.quantumleap:gradle-plugins")
    }
}

apply {
    plugin("cz.quantumleap")
}

dependencies {
    add("compile", project("core"))
    add("compile", project("admin"))
    add("testCompile", "org.springframework.boot:spring-boot-starter-test")
}

val jar: Jar by tasks
jar.baseName = "demo"
jar.version = "0.0.1-SNAPSHOT"
