package com.sandoval.chipperreddittest

import android.app.Application
import com.sandoval.chipperreddittest.di.localModules
import com.sandoval.chipperreddittest.di.networkModules
import com.sandoval.chipperreddittest.di.repositoryModules
import com.sandoval.chipperreddittest.di.useCaseModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

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
                    localModules
                    //TODO: Add the viewModelModules after ViewModel implementation
                )
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}