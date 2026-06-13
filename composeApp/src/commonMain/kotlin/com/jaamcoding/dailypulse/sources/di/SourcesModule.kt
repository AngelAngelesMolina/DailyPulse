package com.jaamcoding.dailypulse.sources.di

import com.jaamcoding.dailypulse.sources.data.SourceRepository
import com.jaamcoding.dailypulse.sources.data.SourcesDataSource
import com.jaamcoding.dailypulse.sources.data.SourcesService
import com.jaamcoding.dailypulse.sources.domain.SourceUseCase
import com.jaamcoding.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourceUseCase> { SourceUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourceRepository> { SourceRepository(get(), get()) }

}