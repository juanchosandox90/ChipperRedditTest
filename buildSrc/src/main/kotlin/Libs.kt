object Libs {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

        object Coroutines {
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }
    }

    object UI {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
        const val browser = "androidx.browser:browser:${Versions.browser}"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
        const val lottieVersion = "com.airbnb.android:lottie:${Versions.lottieVersion}"
        object Navigation {
            const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Arch {
        const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.room}"
            const val ktx = "androidx.room:room-ktx:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
        }
    }

    object Network {
        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
            const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        }

        object OkHttp {
            const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        }

        object Glide {
            const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
            const val okHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
            const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        }
    }

    object Debug {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }

    object Test {
        const val runner = "androidx.test:runner:${Versions.test}"
        const val rules = "androidx.test:rules:${Versions.test}"
        const val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"

        object Espresso {
            const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
            const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
            const val idling = "androidx.test.espresso.idling:idling-concurrent:${Versions.espresso}"
        }

        object Mockito {
            const val core = "org.mockito:mockito-core:${Versions.mockito}"
            const val android = "org.mockito:mockito-android:${Versions.mockito}"
            const val kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
        }
    }
}