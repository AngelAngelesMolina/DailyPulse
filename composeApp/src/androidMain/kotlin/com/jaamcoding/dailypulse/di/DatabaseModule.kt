package com.jaamcoding.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.jaamcoding.dailypulse.db.DatabaseDriverFactory
import jaam.coding.dailypulse.db.DailyPulseDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
