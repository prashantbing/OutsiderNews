package com.prashant.domain.repository.repository

import com.prashant.data.Error
import com.prashant.data.Result
import com.prashant.data.models.ArticleRs
import com.prashant.data.models.PagingDataRs
import com.prashant.domain.repository.remotesource.ArticleRemoteSource

class ArticleRepository(private val articleRemoteSource: ArticleRemoteSource) {

    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> = articleRemoteSource.getArticles()
}