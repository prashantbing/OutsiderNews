package com.multiplatform.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform