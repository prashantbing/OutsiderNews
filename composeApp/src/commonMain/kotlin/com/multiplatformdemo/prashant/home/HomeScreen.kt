package com.multiplatformdemo.prashant.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.multiplatform.domain.models.articles.Article
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun Home(articles: SnapshotStateList<Article>){

    LazyColumn {

        items(articles){
            ArticleItem(it)
            Spacer(Modifier.size(20.dp))
        }

    }

}

@Composable
fun ArticleItem(article: Article) {
    Column(Modifier.height(211.dp).padding(horizontal = 24.dp)) {
        Text(style = textSource, text = article.source?.name.orEmpty(), color = MaterialTheme.colors.primary)
        Spacer(Modifier.size(8.dp))
        Row(Modifier.height(105.dp)) {
            Text(modifier = Modifier.weight(196f), style = textTitle, text = article.title.orEmpty(), color = MaterialTheme.colors.onSurface, overflow = TextOverflow.Ellipsis)
            Spacer(Modifier.size(8.dp))
            AsyncImage(modifier = Modifier.weight(92f).height(86.dp),
            model = article.urlToImage,
                placeholder = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                contentScale = ContentScale.Crop,

     )
        }
        Text( style = textDescription, text = article.description.orEmpty(), color = MaterialTheme.colors.onSurface, overflow = TextOverflow.Ellipsis)
        Spacer(Modifier.size(8.dp))

    }
}

