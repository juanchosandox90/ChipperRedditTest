package com.sandoval.chipperreddittest.presentation

import android.app.Application
import com.sandoval.chipperreddittest.BuildConfig
import com.sandoval.chipperreddittest.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("Unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    useCaseModules,
                    repositoryModules,
                    networkModules,
                    localModules,
                    viewModelModules
                )
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}