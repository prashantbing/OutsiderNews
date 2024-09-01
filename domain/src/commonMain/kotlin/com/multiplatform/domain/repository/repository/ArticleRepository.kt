package com.multiplatform.domain.repository.repository

import com.multiplatform.data.Error
import com.multiplatform.data.Result
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.domain.repository.remotesource.ArticleRemoteSource


class ArticleRepository(private val articleRemoteSource: ArticleRemoteSource) {

    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> = articleRemoteSource.getArticles()
}