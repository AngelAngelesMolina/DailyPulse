package com.jaamcoding.dailypulse.sources.data

import jaam.coding.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(
    private val database: DailyPulseDatabase
) {

    fun getAllSources(): List<SourceRaw> =
        database.dayliPulseDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(sources: List<SourceRaw>) {
        database.dayliPulseDatabaseQueries.transaction {
            sources.forEach { sourceRaw ->
                insertSource(sourceRaw)
            }
        }
    }

    fun clearSources() = database.dayliPulseDatabaseQueries.removeAllSources()

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dayliPulseDatabaseQueries.insertSource(
            name = sourceRaw.name,
            desc = sourceRaw.description,
            country = sourceRaw.country,
            language = sourceRaw.language,
            id = sourceRaw.id
        )
    }

    private fun mapToSourceRaw(
        name: String,
        desc: String?,
        id: String,
        country: String,
        language: String,
    ): SourceRaw {
        return SourceRaw(
            name = name,
            description = desc,
            country = country,
            language = language,
            id = id
        )
    }

}