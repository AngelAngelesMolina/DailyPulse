package com.jaamcoding.dailypulse.sources.domain

import kotlinx.serialization.SerialName

data class Source(
    val name: String,
    val desc: String,
    val countryLanguage: String,
)