pluginManagement {
    // Same check as includeGradlePlugins below; this block can't see other values.
    val includeGradlePlugins = file("local.properties").takeIf { it.exists() }
        ?.let { file -> java.util.Properties().apply { file.inputStream().use { load(it) } } }
        ?.getProperty("includeGradlePlugins")?.toBoolean() == true
    if (includeGradlePlugins && file("../gradle-plugins").exists()) {
        includeBuild("../gradle-plugins")
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Build against ../gradle-plugins from source only when local.properties sets
// includeGradlePlugins=true. Otherwise this repo uses the published plugins, as
// its CI does, so every build uses the same plugins and shares cached outputs.
val includeGradlePlugins = file("local.properties").takeIf { it.exists() }
    ?.let { file -> java.util.Properties().apply { file.inputStream().use { load(it) } } }
    ?.getProperty("includeGradlePlugins")?.toBoolean() == true

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        if (includeGradlePlugins && file("../gradle-plugins").exists()) {
            create("embarrasdfPluginLibs") {
                from(files("../gradle-plugins/gradle/libs.versions.toml"))
            }
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "testing"

include(":maindispatcher-extension")
include(":maindispatcher-rule")
