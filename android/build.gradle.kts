plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "ua.ilyadreamix.cmmc.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "0.0.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // buildTypes {
    //     getByName("release") {
    //         isMinifyEnabled = false
    //     }
    // }
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.6.1")
}
