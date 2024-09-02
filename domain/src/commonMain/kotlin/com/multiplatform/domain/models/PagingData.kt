package com.multiplatform.domain.models


data class PagingData<T>(
    val data: List<T>?,
    val status: String?,
    val totalResults: Int?
)