package com.multiplatformdemo.prashant

import androidx.compose.material3.ColorScheme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val colorScheme : ColorScheme