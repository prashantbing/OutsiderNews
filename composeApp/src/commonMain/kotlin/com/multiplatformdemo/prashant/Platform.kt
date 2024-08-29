package com.multiplatformdemo.prashant

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform