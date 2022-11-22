package com.ghennadiiganenko.android.ecommerce.app

import android.app.Application
import com.ghennadiiganenko.android.ecommerce.BuildConfig
import com.ghennadiiganenko.android.ecommerce.di.appModule
import com.ghennadiiganenko.android.ecommerce.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }

    }
}