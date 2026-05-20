package com.jaamcoding.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status : String,
    @SerialName("totalResults")
    val totalStatus : Int,
    @SerialName("articles")
    val articles : List<ArticleRaw>
)