plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlinx-serialization")
}

android {
    defaultConfig {
        applicationId = "com.fabiocarballo.taxi"
    }

    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
        // Sets Java compatibility to Java 8
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // internal
    implementation(projects.design.foundation)
    implementation(projects.design.components)

    // third party
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.foundation.core)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.ui.main)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.material)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.datetime)

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    // test implementation
    testImplementation(libs.junit4)
    testImplementation(libs.turbine)
    testImplementation(kotlin("test"))
    testImplementation(libs.kotlinx.test.coroutines)
}

