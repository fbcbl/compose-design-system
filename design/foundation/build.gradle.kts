plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    implementation(libs.androidx.compose.foundation.core)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.main)
    implementation(libs.androidx.compose.ui.main)
    implementation(libs.androidx.compose.ui.util)
}
