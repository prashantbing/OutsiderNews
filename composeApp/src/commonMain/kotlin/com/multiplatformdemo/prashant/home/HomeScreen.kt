package com.multiplatformdemo.prashant.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.multiplatform.domain.models.articles.Article

@Composable
fun Home(articles: SnapshotStateList<Article>){

    LazyColumn {

        items(articles){
            ArticleItem(it)
        }

    }

}

@Composable
fun ArticleItem(article: Article) {

}