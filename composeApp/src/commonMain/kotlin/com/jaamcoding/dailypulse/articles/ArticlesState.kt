package com.jaamcoding.dailypulse.articles

 data class ArticlesState(
  val articles : List<Article> = emptyList(),
  val isLoading : Boolean = false,
  val isError : String? = null,
)