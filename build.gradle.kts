import com.android.build.gradle.BaseExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    // TODO Gradle: Workaround for https://github.com/gradle/gradle/issues/16958#issue-866175042
    @Suppress("UnstableApiUsage")
    val libs = project.extensions.getByType<VersionCatalogsExtension>()
        .named("libs") as org.gradle.accessors.dm.LibrariesForLibs


    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
        classpath(libs.shot)
    }
}


subprojects {
    afterEvaluate {
        extensions.findByType(BaseExtension::class)?.let {
            configureBaseExtension(it)
        }
    }
}

fun configureBaseExtension(extension: BaseExtension): Unit =
    with(extension) {
        compileSdkVersion(31)

        defaultConfig {
            minSdk = 21
            targetSdk = 31
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "com.karumi.shot.ShotTestRunner"
            vectorDrawables.useSupportLibrary = true
        }

        packagingOptions {
            resources.excludes.add("META-INF/{AL2.0,LGPL2.1}")
        }

        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.androidx.compose.get()
        }
    }

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
