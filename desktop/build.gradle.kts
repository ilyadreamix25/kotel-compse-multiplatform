import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {}
    sourceSets {
        named("jvmMain") {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            jvmArgs("-Dapple.awt.application.appearance=system")

            packageName = "MaterialCatalog"
            packageVersion = "1.0.0"

            windows {
                menu = true
                upgradeUuid = "A99824AD-4FDA-4CD4-A324-AC95CAB3D85B"
            }

            macOS {
                bundleID = "ua.ilyadreamix.cmmc.macos"
            }
        }
    }
}
