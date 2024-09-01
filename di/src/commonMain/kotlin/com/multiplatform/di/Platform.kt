package com.multiplatform.di

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform