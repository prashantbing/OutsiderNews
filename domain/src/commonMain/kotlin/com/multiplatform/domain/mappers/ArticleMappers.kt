package com.multiplatform.domain.mappers

import com.multiplatform.data.models.ArticleRs
import com.multiplatform.data.models.SourceRs
import com.multiplatform.domain.models.articles.Article
import com.multiplatform.domain.models.articles.Source

fun ArticleRs.toArticle() = Article(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    source = source?.toSource(),
    title = title,
    url = url,
    urlToImage = urlToImage
)

private fun SourceRs.toSource(): Source =
                             Source(
                                 id = id, name = name

                             )

