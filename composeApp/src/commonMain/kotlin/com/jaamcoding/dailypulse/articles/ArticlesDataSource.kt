package com.jaamcoding.dailypulse.articles

import jaam.coding.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(
    private val database: DailyPulseDatabase,
) {

    fun getAllArticles(): List<ArticleRaw> =
        database.dayliPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dayliPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw -> insertArticle(articleRaw) }
        }
    }

    fun clearArticles() = database.dayliPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {

        database.dayliPulseDatabaseQueries.insertArticle(
            title = articleRaw.title,
            desc = articleRaw.description,
            date = articleRaw.date,
            imageUrl = articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?,
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = desc,
        date = date,
        imageUrl = imageUrl,
    )

}