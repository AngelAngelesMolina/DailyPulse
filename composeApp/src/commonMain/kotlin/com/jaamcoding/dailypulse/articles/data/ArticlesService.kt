package com.jaamcoding.dailypulse.articles.data

import com.jaamcoding.dailypulse.AppSecrets
import com.jaamcoding.dailypulse.Constants.BASE_URL
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
            client.get("$BASE_URL/top-headlines?country=$country&category=$category&apiKey=${AppSecrets.NEWS_API_KEY}")
                .body()
        return response.articles
    }
}

