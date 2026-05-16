package com.jaamcoding.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform