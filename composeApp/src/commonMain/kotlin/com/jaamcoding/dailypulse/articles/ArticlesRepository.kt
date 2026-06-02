package com.jaamcoding.dailypulse.articles

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService,
) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()
        if (articlesDb.isEmpty()) {
            val fetchArticles = service.getArticles()
            dataSource.insertArticles(fetchArticles)
            return fetchArticles
        } else {
            return articlesDb
        }
    }


}