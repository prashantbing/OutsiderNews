package com.multiplatformdemo.prashant.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.multiplatform.domain.models.articles.Article
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun Home(articles: SnapshotStateList<Article>) {

    LazyColumn {

        itemsIndexed(articles) { index, article ->
            when {
                index == 0 -> HeadlineItem(article)
                (                index+1)%3==0 -> ArticleItemVariant(article)
                else -> {
                    ArticleItem(article)
                    Spacer(Modifier.size(20.dp))
                }
            }

        }

    }

}

@Composable
fun ArticleItem(article: Article) {
    Column(Modifier.heightIn(max=211.dp).padding(horizontal = 24.dp)) {
        Text(
            style = textSource,
            text = article.source?.name.orEmpty(),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.size(8.dp))
        Row(Modifier.height(105.dp)) {
            Text(
                modifier = Modifier.weight(196f),
                style = textTitle,
                text = article.title.orEmpty(),
                color = MaterialTheme.colorScheme.onSurface,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.size(8.dp))
            AsyncImage(
                modifier = Modifier.weight(92f).height(86.dp),
                model = article.urlToImage,
                placeholder = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
        }
        Text(
            style = textDescription,
            text = article.description.orEmpty(),
            color = MaterialTheme.colorScheme.onSurface,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.size(8.dp))

    }
}

@Composable
fun ArticleItemVariant(article: Article) {
    Column(Modifier.padding(horizontal = 24.dp)) {
        Row {
            AsyncImage(
                modifier = Modifier.width(99.dp).height(74.dp).padding(top = 24.dp),
                model = article.urlToImage,
                placeholder = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
            Spacer(Modifier.size(12.dp))

            Column {

                Text(
                    style = textSource,
                    text = article.source?.name.orEmpty(),
                    color = MaterialTheme.colorScheme.primary
                )


                Spacer(Modifier.size(8.dp))

                Text(
                    style = textDescription.copy(fontSize = 16.sp),
                    text = article.title.orEmpty(),
                    color = MaterialTheme.colorScheme.onSurface,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.size(8.dp))


                Text(
                    style = textInput.copy(fontSize = 14.sp),
                    text = article.publishedAt.orEmpty(),
                    color = Color(0xFF6D787A),
                    overflow = TextOverflow.Ellipsis
                )

            }

        }
        Spacer(Modifier.size(24.dp))
        HorizontalDivider()
        Spacer(Modifier.size(24.dp))
    }

}


@Composable
fun HeadlineItem(article: Article) {
    Column(Modifier.padding(horizontal = 24.dp)) {
        Text(
            style = textSource,
            text = article.source?.name.orEmpty(),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.size(8.dp))
        Text(
            style = textTitle,
            text = article.title.orEmpty(),
            color = MaterialTheme.colorScheme.onSurface,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(Modifier.size(8.dp))
        AsyncImage(
            modifier = Modifier.fillMaxWidth().height(240.dp),
            model = article.urlToImage,
            placeholder = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.size(24.dp))
        HorizontalDivider()
        Spacer(Modifier.size(24.dp))

    }
}

