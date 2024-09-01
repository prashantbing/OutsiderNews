package com.multiplatform.domain.repository.remotesource

import com.multiplatform.data.Error
import com.multiplatform.data.Result
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.data.services.ArticleService


class ArticleRemoteSource(private val articleService: ArticleService) {


    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> = articleService.getArticles()


}