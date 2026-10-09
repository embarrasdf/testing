pluginManagement {
    val embarrasdfGradlePluginsVersion = file("gradle/libs.versions.toml").readLines()
        .first { it.startsWith("embarrasdf-gradle-plugins") }
        .substringAfter('"').substringBefore('"')
    plugins {
        id("com.embarrasdf.gradle.plugin.settings") version embarrasdfGradlePluginsVersion
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.embarrasdf.gradle.plugin.settings")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "testing"

include(":maindispatcher-extension")
include(":maindispatcher-rule")
