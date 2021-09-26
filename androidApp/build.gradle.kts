plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    val compose = "1.1.0-alpha04"
    val ui = "androidx.compose.ui:ui:${compose}"
    val uiGraphics = "androidx.compose.ui:ui-graphics:${compose}"
    val uiTooling = "androidx.compose.ui:ui-tooling:${compose}"
    val foundationLayout = "androidx.compose.foundation:foundation-layout:${compose}"
    val material = "androidx.compose.material:material:${compose}"

    implementation(ui)
    implementation(uiGraphics)
    implementation(foundationLayout)
    implementation(material)
    implementation(uiTooling)
    implementation("androidx.activity:activity-compose:1.3.1")


    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.example.mykmmcheck.android"
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-alpha04"
    }
}