pluginManagement {
    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

include("core", "coretest", "admin")

for (child in rootProject.children) {
    child.projectDir = File(settingsDir, "quantumleap/${child.name}")
    assert(child.projectDir.isDirectory)
    assert(child.buildFile.isFile)
}
