package com.jaamcoding.dailypulse.sources.presentation

import com.jaamcoding.dailypulse.BaseViewModel
import com.jaamcoding.dailypulse.articles.presentation.ArticlesState
import com.jaamcoding.dailypulse.sources.domain.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val useCase: SourceUseCase
) : BaseViewModel() {
    private val _sourcesState: MutableStateFlow<SourcesState> = MutableStateFlow(
        SourcesState(
            isLoading = true
        )
    )
    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        getSources()
    }

    fun getSources(forceFetch: Boolean = false) {
        scope.launch {
            try {
                _sourcesState.emit(
                    SourcesState(
                        isLoading = true,
                        sources = sourcesState.value.sources,
                    )
                )
                val fetchedSources= useCase.getSources(forceFetch)

                _sourcesState.emit(
                    SourcesState(
                        sources = fetchedSources,
                        isLoading = false,
                        isError = null
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _sourcesState.emit(
                    SourcesState(
                        isLoading = false,
                        isError = e.message ?: "Unknown error"
                    )
                )
            }
        }
    }
}