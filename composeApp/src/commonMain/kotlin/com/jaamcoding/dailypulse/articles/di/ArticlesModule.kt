package com.jaamcoding.dailypulse.articles.di

import com.jaamcoding.dailypulse.articles.ArticlesDataSource
import com.jaamcoding.dailypulse.articles.ArticlesRepository
import com.jaamcoding.dailypulse.articles.ArticlesService
import com.jaamcoding.dailypulse.articles.ArticlesUseCase
import com.jaamcoding.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module


val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }

}