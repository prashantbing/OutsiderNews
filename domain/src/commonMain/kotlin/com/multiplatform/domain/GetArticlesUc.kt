package com.multiplatform.domain

import com.multiplatform.data.Error
import com.multiplatform.data.Result
import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.PagingDataRs
import com.multiplatform.domain.repository.repository.ArticleRepository

class GetArticlesUc(private val articleRepository: ArticleRepository) {

     suspend operator fun invoke(): Result<PagingDataRs<ArticleRs>, Error> {
      return  articleRepository.getArticles()
    }
}