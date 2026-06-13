package com.jaamcoding.dailypulse.sources.domain

import com.jaamcoding.dailypulse.sources.data.SourceRaw
import com.jaamcoding.dailypulse.sources.data.SourceRepository

class SourceUseCase(
    private val repository: SourceRepository
) {
    suspend fun getSources(forceFetch: Boolean): List<Source> {
        val sourcesRaw = repository.getSources(forceFetch)
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> =
        sourcesRaw.map { sourceRaw ->
            Source(
                name = sourceRaw.name,
                desc = sourceRaw.description ?: "",
                countryLanguage = "${sourceRaw.country} - ${sourceRaw.language}",
            )
        }

}