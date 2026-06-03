package com.jaamcoding.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.jaamcoding.dailypulse.db.DatabaseDriverFactory
import jaam.coding.dailypulse.db.DailyPulseDatabase
import jaam.coding.dailypulse.db.DailyPulseDatabase.Companion.invoke
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}