pluginManagement {
    includeBuild("quantumleap/gradle-plugin")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://jitpack.io") { name = "JitPack" }
    }
}

include("core", "coretest", "admin")

for (child in rootProject.children) {
    child.projectDir = File(settingsDir, "quantumleap/${child.name}")
    assert(child.projectDir.isDirectory)
    assert(child.buildFile.isFile)
}
