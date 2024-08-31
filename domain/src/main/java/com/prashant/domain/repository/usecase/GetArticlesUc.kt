package com.prashant.domain.repository.usecase

import com.prashant.data.Error
import com.prashant.data.Result
import com.prashant.data.models.ArticleRs
import com.prashant.data.models.PagingDataRs
import com.prashant.domain.repository.repository.ArticleRepository

class GetArticlesUc(private val articleRepository: ArticleRepository) {

     suspend operator fun invoke(): Result<PagingDataRs<ArticleRs>, Error> {
      return  articleRepository.getArticles()
    }
}