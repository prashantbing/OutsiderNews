package com.multiplatform.domain.repository.remotesource

import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.data.services.ArticleService
import com.multiplatform.utility.Error
import com.multiplatform.utility.Result


class ArticleRemoteSource(private val articleService: ArticleService) {


    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> = articleService.getArticles()


}