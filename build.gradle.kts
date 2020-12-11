plugins {
    java
    id("io.papermc.paperweight") version "1.0.0-SNAPSHOT"
}

group = "com.destroystokyo.paper"
version = "1.16.4-R0.1-SNAPSHOT"

val mcVersion = providers.gradleProperty("mcVersion")

allprojects {
    apply(plugin = "java")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(11))
        }
    }
}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(8)
    }

    repositories {
        mavenCentral()
        maven("https://repo1.maven.org/maven2/")
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://ci.emc.gs/nexus/content/groups/aikar/")
        maven("https://repo.md-5.net/content/repositories/releases/")
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    }
}

dependencies {
    paramMappings("net.fabricmc:yarn:1.16.4+build.7:mergedv2")
    remapper("net.fabricmc:tiny-remapper:0.3.1.72:fat@jar")
    decompiler("net.minecraftforge:forgeflower:1.5.478.18@jar")
}

paperweight {
    minecraftVersion.set(mcVersion)
    serverProject.set(project(":Paper-Server"))

    paper {
        mappingsPatch.set(file("build-data/mappings-patch.tiny"))
    }
}
