package com.jaamcoding.dailypulse.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(
    private val client: HttpClient
) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "b2139932c19c4656b80493696042a2c9"
    suspend fun getArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            client.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }

    suspend fun getSources(): List<SourceRaw> {
        val response: SourceResponse =
            client.get("https://newsapi.org/v2/top-headlines/sources")
                .body()
        return response.sources
    }
}

