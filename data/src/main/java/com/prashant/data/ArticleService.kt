package com.prashant.data

import com.prashant.data.models.ArticleRs
import com.prashant.data.models.PagingDataRs

class ArticleService (private val client: NetworkClient) {

    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> =
        client.get(
        urlString = "https://www.purgomalum.com/service/json"
    )


}