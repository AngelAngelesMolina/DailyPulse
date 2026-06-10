package com.jaamcoding.dailypulse.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService,
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            println("articlesDb: force called!")
            dataSource.clearArticles()
            return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        println("articlesDb: ${articlesDb.size}")

        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchArticles = service.getArticles()
        dataSource.insertArticles(fetchArticles)
        return fetchArticles
    }

}