package com.jaamcoding.dailypulse.sources.data

class SourceRepository(
    private val dataSource: SourcesDataSource,
    private val service: SourcesService,
) {
    suspend fun getSources(forceFetch: Boolean): List<SourceRaw> {
        if (forceFetch) {
            dataSource.clearSources()
            return fetchSources()
        }
        val articlesDb = dataSource.getAllSources()
        println("Sources: ${articlesDb.size}")

        if (articlesDb.isEmpty()) {
            return fetchSources()
        }
        return articlesDb
    }

    private suspend fun fetchSources(): List<SourceRaw> {
        val fetchSources = service.getSources()
        dataSource.insertSources(fetchSources)
        return fetchSources
    }
}