pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.demonwav.com/snapshots/")
    }
}

rootProject.name = "Paper"
include("Paper-API", "Paper-Server", "Paper-MojangAPI")
