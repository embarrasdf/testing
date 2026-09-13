import com.embarrasdf.testing.maindispatcherrule.convention.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.jvm")
        }

        kotlin {
            jvmToolchain(11) // or your preferred JVM version
            configureKotlin()
        }
    }
}

internal fun Project.kotlin(action: KotlinJvmProjectExtension.() -> Unit) {
    extensions.configure<KotlinJvmProjectExtension>(action)
}

internal val Project.kotlin: KotlinJvmProjectExtension
    get() = extensions.getByType<KotlinJvmProjectExtension>()
