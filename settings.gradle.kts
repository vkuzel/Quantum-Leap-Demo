includeBuild("quantumleap/gradle-plugins")

include("core", "admin")

for (child in rootProject.children) {
    val projectDirName = "quantumleap/${child.name}"
    child.projectDir = File(settingsDir, projectDirName)
    assert(child.projectDir.isDirectory)
    assert(child.buildFile.isFile)
}
