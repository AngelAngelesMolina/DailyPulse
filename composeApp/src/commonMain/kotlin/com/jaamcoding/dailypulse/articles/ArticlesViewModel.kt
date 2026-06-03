package com.jaamcoding.dailypulse.articles

import com.jaamcoding.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

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
        scope.launch { //asyncronus code

            val fetchedArtcles = useCase.getArticles(forceFetch)
            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArtcles,
                    isLoading = false,
                    isError = null
                )
            )
        }
    }

}