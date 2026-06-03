package com.jaamcoding.dailypulse.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import jaam.coding.dailypulse.db.DailyPulseDatabase

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(DailyPulseDatabase.Schema, "DailyPulseDatabase.db")
}