@file:Suppress("UnstableApiUsage")

include(":app")

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:${Versions.androidGradle}")
            }

            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion(Versions.kotlin)
            }
        }
    }
}