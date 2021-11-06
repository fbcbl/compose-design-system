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
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
