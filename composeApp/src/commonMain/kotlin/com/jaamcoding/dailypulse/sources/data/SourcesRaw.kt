package com.jaamcoding.dailypulse.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceRaw(
    @SerialName("country")
    val country: String,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String,
    @SerialName("language")
    val language: String,
    @SerialName("name")
    val name: String
)

