import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.compileSdk)

    defaultConfig {
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = Config.versionCode
        versionName = Config.versionName
        applicationId = Config.applicationId

        testInstrumentationRunner = "com.sandoval.chipperrreddittest.TestAppJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true",
                        "room.expandProjection" to "true"
                    )
                )
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildToolsVersion = Config.buildTools

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        val main by getting
        val androidTest by getting

        main.java.srcDirs("src/main/kotlin")
        androidTest.java.srcDirs("src/androidTest/kotlin")
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.Coroutines.coroutines)
    implementation(Libs.Kotlin.Coroutines.android)

    implementation(Libs.UI.appcompat)
    implementation(Libs.UI.coreKtx)
    implementation(Libs.UI.constraintLayout)
    implementation(Libs.UI.material)
    implementation(Libs.UI.recyclerView)
    implementation(Libs.UI.Navigation.fragment)
    implementation(Libs.UI.Navigation.ui)
    implementation(Libs.UI.paging)
    implementation(Libs.UI.browser)
    implementation(Libs.UI.swipeRefresh)
    implementation(Libs.UI.lottieVersion)

    implementation(Libs.Arch.koin)
    implementation(Libs.Arch.lifecycle)
    implementation(Libs.Arch.Room.runtime)
    implementation(Libs.Arch.Room.ktx)
    kapt(Libs.Arch.Room.compiler)

    implementation(Libs.Network.Retrofit.retrofit)
    implementation(Libs.Network.Retrofit.converterMoshi)
    implementation(Libs.Network.OkHttp.okHttp)
    implementation(Libs.Network.OkHttp.loggingInterceptor)
    implementation(Libs.Network.Glide.glide)
    implementation(Libs.Network.Glide.okHttp) { isTransitive = false }
    kapt(Libs.Network.Glide.compiler)

    implementation(Libs.Debug.timber)

    androidTestImplementation(Libs.Test.runner)
    androidTestImplementation(Libs.Test.rules)
    androidTestImplementation(Libs.Test.kakao)
    androidTestImplementation(Libs.Test.Espresso.core)
    androidTestImplementation(Libs.Test.Espresso.contrib)
    androidTestImplementation(Libs.Test.Espresso.idling)
    androidTestImplementation(Libs.Test.Mockito.core)
    androidTestImplementation(Libs.Test.Mockito.android)
    androidTestImplementation(Libs.Test.Mockito.kotlin) { isTransitive = false }
}
