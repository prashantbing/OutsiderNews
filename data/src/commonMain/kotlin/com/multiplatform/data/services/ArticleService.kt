package com.multiplatform.data.services

import com.multiplatform.data.NetworkClient
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.utility.Constants
import com.multiplatform.utility.Error
import com.multiplatform.utility.Result

class ArticleService (private val client: NetworkClient) {

    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> =
        client.get(
        urlString = "${Constants.BASE_URL}NewsAPI/top-headlines/category/health/in.json"
    )


}