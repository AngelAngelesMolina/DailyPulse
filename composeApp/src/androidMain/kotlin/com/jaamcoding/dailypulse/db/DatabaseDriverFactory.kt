package com.jaamcoding.dailypulse.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import jaam.coding.dailypulse.db.DailyPulseDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(DailyPulseDatabase.Schema, context, "DailyPulseDatabase.db")
    }
}