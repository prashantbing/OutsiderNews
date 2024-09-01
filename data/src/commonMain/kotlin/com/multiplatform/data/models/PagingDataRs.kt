package com.multiplatform.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagingDataRs<T>(
    @SerialName("articles")
    val articles: List<T>?,
    @SerialName("status")
    val status: String?,
    @SerialName("totalResults")
    val totalResults: Int?
)