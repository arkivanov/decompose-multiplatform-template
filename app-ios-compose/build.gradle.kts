import org.jetbrains.compose.experimental.dsl.IOSDevices
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    listOf(
        iosX64("uikitX64"),
        iosArm64("uikitArm64"),
        iosSimulatorArm64("uikitSimulatorArm64"),
    ).forEach {
        it.binaries {
            executable {
                entryPoint = "com.example.myapplication.ios.main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(project(":compose-ui"))

                implementation(libs.decompose.decompose)
                implementation(libs.decompose.extensionsComposeJetbrains)
            }
        }
    }

    targets.withType<KotlinNativeTarget> {
        binaries.all {
            // TODO: the current compose binary surprises LLVM, so disable checks for now.
            freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
        }
    }
}

compose.experimental {
    uikit.application {
        bundleIdPrefix = "com.example.myapplication.ios"
        projectName = "DecomposeTemplate"

        deployConfigurations {
            simulator("IPhone12Pro") {
                // Usage: ./gradlew iosDeployIPhone12ProDebug
                device = IOSDevices.IPHONE_12_PRO
            }

            /*
             * Usage: ./gradlew iosDeployDeviceDebug
             *
             * If your are getting "A valid provisioning profile for this executable was not found" error,
             * see: https://developer.apple.com/forums/thread/128121?answerId=403323022#403323022
             */
            connectedDevice("Device") {
                // Uncomment and fill with your Team ID
                // teamId = ""
            }
        }
    }
}
