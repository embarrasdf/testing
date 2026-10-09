pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Builds against ../gradle-plugins from source when local.properties sets
    // includeGradlePlugins=true; otherwise uses the published plugins, like CI.
    id("com.embarrasdf.gradle.plugin.settings") version "0.0.134"
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
