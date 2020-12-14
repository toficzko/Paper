pluginManagement {
    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://files.minecraftforge.net/maven/")
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
        mavenLocal()
    }
}

rootProject.name = "Paper"
include("Paper-API", "Paper-Server", "Paper-MojangAPI")
