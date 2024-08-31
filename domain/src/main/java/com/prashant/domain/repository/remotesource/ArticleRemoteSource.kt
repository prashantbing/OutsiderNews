package com.prashant.domain.repository.remotesource

import com.prashant.data.ArticleService
import com.prashant.data.Error
import com.prashant.data.NetworkClient
import com.prashant.data.Result
import com.prashant.data.models.ArticleRs
import com.prashant.data.models.PagingDataRs

class ArticleRemoteSource(private val articleService: ArticleService) {


    suspend fun getArticles(): Result<PagingDataRs<ArticleRs>, Error> = articleService.getArticles()


}