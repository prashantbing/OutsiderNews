package com.multiplatformdemo.prashant.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.multiplatform.domain.models.articles.Article
import com.multiplatform.domain.models.articles.Source
import com.multiplatformdemo.prashant.home.ArticleItem

@Preview
@Composable
fun ArticleItemPreview(){
    ArticleItem(
        article = Article(
            author = null,
            content = null,
            description = null,
            publishedAt = null,
            source = Source("", "eryyt"),
            title = "Where to watch the first 3 'John Wick' movies before you see 'Chapter 4'",
            url = null,
            urlToImage = null
        )
    )
}
