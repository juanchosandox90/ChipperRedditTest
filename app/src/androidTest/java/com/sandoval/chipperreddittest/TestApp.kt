package com.sandoval.chipperreddittest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TestApp)
        }
    }

    private fun initTimber() = Timber.plant(Timber.DebugTree())
}
