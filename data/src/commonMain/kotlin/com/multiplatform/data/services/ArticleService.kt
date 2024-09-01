package com.multiplatform.data.services

import com.multiplatform.data.Error
import com.multiplatform.data.NetworkClient
import com.multiplatform.data.Result
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs

class ArticleService (private val client: NetworkClient) {

    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> =
        client.get(
        urlString = "https://www.purgomalum.com/service/json"
    )


}