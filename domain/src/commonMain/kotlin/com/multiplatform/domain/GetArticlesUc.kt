package com.multiplatform.domain

import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.domain.models.PagingData
import com.multiplatform.domain.models.articles.Article
import com.multiplatform.domain.repository.repository.ArticleRepository
import com.multiplatform.utility.Error
import com.multiplatform.utility.Result

class GetArticlesUc(private val articleRepository: ArticleRepository) {

     suspend operator fun invoke(): Result<PagingData<Article>, Error> =
         articleRepository.getArticles()
}