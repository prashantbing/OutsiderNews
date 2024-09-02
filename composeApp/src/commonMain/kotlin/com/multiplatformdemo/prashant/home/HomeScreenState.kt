package com.multiplatformdemo.prashant.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.multiplatform.domain.models.articles.Article

data class HomeScreenState(
    val article: SnapshotStateList<Article> = mutableStateListOf(),
    val isLoading: Boolean =false
)