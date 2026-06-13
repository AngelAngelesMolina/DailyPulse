package com.jaamcoding.dailypulse.sources.presentation

import com.jaamcoding.dailypulse.articles.domain.Article
import com.jaamcoding.dailypulse.sources.domain.Source

data class SourcesState(
    val sources : List<Source> = emptyList(),
    val isLoading : Boolean = false,
    val isError : String? = null,
)