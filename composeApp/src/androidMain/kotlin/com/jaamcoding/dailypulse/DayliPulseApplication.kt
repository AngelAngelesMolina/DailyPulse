package com.jaamcoding.dailypulse

import android.app.Application
import com.jaamcoding.dailypulse.di.sharedKoinModule
import com.jaamcoding.dailypulse.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DayliPulseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule
        startKoin {
            androidContext(this@DayliPulseApplication)
            modules(modules)
        }

    }
}