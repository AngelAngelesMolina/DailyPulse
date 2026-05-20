package com.jaamcoding.dailypulse.articles

class ArticlesUseCase(
    private val service: ArticlesService
) {

    suspend fun getArticles(): List<Article> {
        val articlesRaw = service.getArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> =
        articlesRaw.map { articleRaw ->
            Article(
                title = articleRaw.title,
                description = articleRaw.description ?: "Click to find out more",
                date = articleRaw.date,
                imageUrl = articleRaw.imageUrl
                    ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
            )
        }


}