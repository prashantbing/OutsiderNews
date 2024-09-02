package com.multiplatform.domain.repository.repository

import com.multiplatform.utility.Error
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.domain.mappers.map
import com.multiplatform.domain.mappers.mapToDomain
import com.multiplatform.domain.mappers.toArticle
import com.multiplatform.domain.models.PagingData
import com.multiplatform.domain.models.articles.Article
import com.multiplatform.domain.repository.remotesource.ArticleRemoteSource
import com.multiplatform.utility.Result


class ArticleRepository(private val articleRemoteSource: ArticleRemoteSource) {

    suspend fun getArticles(): Result<PagingData<Article>, Error> =
        articleRemoteSource.getArticles().map {
            it.mapToDomain { articleRs ->
                articleRs.toArticle()
            }
        }
}