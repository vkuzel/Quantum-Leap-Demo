pluginManagement {
    includeBuild("quantumleap/gradle-plugin")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include("quantumleap:core", "quantumleap:coretest", "quantumleap:admin")
