package com.jaamcoding.dailypulse.articles

import com.jaamcoding.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(
        ArticlesState(
            isLoading = true
        )
    )
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch { //asyncronus code
            val fetchedArtcles = fetchArticles()
            delay(500)
            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArtcles,
                    isLoading = false
                )
            )
        }
    }

    suspend fun fetchArticles(): List<Article> {
        return getDummyArticles()
    }

    fun getDummyArticles(): List<Article> {
        return listOf(
            Article(
                title = "Kotlin Multiplatform Keeps Growing",
                description = "More companies are adopting Kotlin Multiplatform for shared business logic across Android and iOS.",
                date = "2026-05-17",
                imageUrl = "https://picsum.photos/400/200?1"
            ),
            Article(
                title = "Jetpack Compose Reaches New Milestone",
                description = "Compose continues becoming the preferred UI toolkit for modern Android development.",
                date = "2026-05-16",
                imageUrl = "https://picsum.photos/400/200?2"
            ),
            Article(
                title = "Coroutines Simplify Async Programming",
                description = "Developers are increasingly using coroutines for cleaner and more maintainable asynchronous code.",
                date = "2026-05-15",
                imageUrl = "https://picsum.photos/400/200?3"
            ),
            Article(
                title = "AI Tools Transform Mobile Development",
                description = "AI-assisted coding tools are helping developers prototype apps and features much faster.",
                date = "2026-05-14",
                imageUrl = "https://picsum.photos/400/200?4"
            )
        )
    }


}