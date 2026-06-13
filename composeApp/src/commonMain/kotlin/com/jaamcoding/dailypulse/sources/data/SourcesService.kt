package com.jaamcoding.dailypulse.sources.data

import com.jaamcoding.dailypulse.Constants.API_KEY
import com.jaamcoding.dailypulse.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(
    private val client: HttpClient
) {

    suspend fun getSources(): List<SourceRaw> {
        val response: SourceResponse =
            client.get("$BASE_URL/top-headlines/sources?apiKey=$API_KEY")
                .body()
        return response.sources
    }

}