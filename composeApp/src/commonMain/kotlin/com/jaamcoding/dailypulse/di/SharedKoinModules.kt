package com.jaamcoding.dailypulse.di

import com.jaamcoding.dailypulse.articles.di.articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)