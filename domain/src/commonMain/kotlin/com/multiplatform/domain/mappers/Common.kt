package com.multiplatform.domain.mappers

import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.domain.models.PagingData
import com.multiplatform.utility.Error
import com.multiplatform.utility.Result

fun <T,V>PagingDataRs<T>.mapToDomain(toDomain: (it:T)-> V)= PagingData(
    data = articles?.map { toDomain(it) },
    status = status,
    totalResults = totalResults
)

fun <T,V> Result<T, Error>.map( toDomain: (it:T)-> V)=
    when (this) {
        is Result.Error -> this
        is Result.Success -> Result.Success(toDomain(this.data))
    }
