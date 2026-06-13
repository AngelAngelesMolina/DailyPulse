package com.jaamcoding.dailypulse.articles.presentation

import com.jaamcoding.dailypulse.BaseViewModel
import com.jaamcoding.dailypulse.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(
        ArticlesState(
            isLoading = true
        )
    )
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            try {
                _articlesState.emit(
                    ArticlesState(
                        isLoading = true,
                        articles = _articlesState.value.articles,
                    )
                )
                val fetchedArticles = useCase.getArticles(forceFetch)

                _articlesState.emit(
                    ArticlesState(
                        articles = fetchedArticles,
                        isLoading = false,
                        isError = null
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _articlesState.emit(
                    ArticlesState(
                        isLoading = false,
                        isError = e.message ?: "Unknown error"
                    )
                )
            }
        }
    }

}