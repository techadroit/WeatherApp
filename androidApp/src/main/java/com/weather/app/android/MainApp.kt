package com.weather.app.android

import android.app.Application
import com.weather.app.android.modules.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApp)
            // Load modules
            modules(viewmodelModule)
        }
    }
}
