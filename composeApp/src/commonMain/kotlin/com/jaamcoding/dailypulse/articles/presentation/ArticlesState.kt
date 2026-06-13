package com.jaamcoding.dailypulse.articles.presentation

import com.jaamcoding.dailypulse.articles.domain.Article

data class ArticlesState(
    val articles : List<Article> = emptyList(),
    val isLoading : Boolean = false,
    val isError : String? = null,
)