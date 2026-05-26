package com.jaamcoding.dailypulse.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaamcoding.dailypulse.articles.ArticlesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module{

    viewModel { ArticlesViewModel(get()) }

}