package com.prashant.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceRs(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)