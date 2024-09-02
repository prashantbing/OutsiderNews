package com.multiplatform.utility

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform