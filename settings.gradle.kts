pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "decompose-template"
include(":shared")
include(":compose-ui")
include(":app-android")
include(":app-desktop")
