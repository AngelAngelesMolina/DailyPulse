package com.jaamcoding.dailypulse.di

import com.jaamcoding.dailypulse.articles.di.articlesModule
import com.jaamcoding.dailypulse.sources.di.sourcesModule

val sharedKoinModule = listOf(
    articlesModule,
    sourcesModule,
    networkModule,

)