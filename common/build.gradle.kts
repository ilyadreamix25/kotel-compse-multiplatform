@file:Suppress("UnstableApiUsage")
@file:OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                api(compose.materialIconsExtended)
            }
        }
        named("androidMain") {
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                api("androidx.appcompat:appcompat:1.6.0")
                api("androidx.core:core-ktx:1.9.0")
            }
        }
        named("desktopMain") {
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                api(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}
