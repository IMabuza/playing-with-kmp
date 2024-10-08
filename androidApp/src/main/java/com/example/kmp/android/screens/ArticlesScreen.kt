package com.example.kmp.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kmp.articles.Article
import com.example.kmp.articles.ArticlesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ArticlesScreen(articlesViewModel: ArticlesViewModel = getViewModel(), onAboutButtonClick: () -> Unit){
    val articlesState = articlesViewModel.articlesState.collectAsState()
    Column {
        AppBar(onAboutButtonClick)
        if(articlesState.value.isLoading)
            Loader()
        if(articlesState.value.error != null)
            ErrorMessage(message = articlesState.value.error!!)
        if(articlesState.value.articles.isNotEmpty())
            ArticlesListView(articlesViewModel.articlesState.value.articles)
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
       Text(text = message, style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center))
}

}

@Composable
fun Loader() {
   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
       CircularProgressIndicator(modifier = Modifier.width(64.dp), color = MaterialTheme.colorScheme.surfaceVariant,
           trackColor = MaterialTheme.colorScheme.secondary)

   }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(onAboutButtonClick: () -> Unit){

            TopAppBar(title = { Text(text = "Artciles")}, actions = {
                IconButton(onClick = onAboutButtonClick) {
                    Icon(imageVector = Icons.Outlined.Info, contentDescription = "About Device Button")
                }
            })

}

@Composable
fun ArticlesListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles){
            article -> ArticleItemView(article = article)
        }
    }
}

@Composable
fun ArticleItemView(article: Article) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        AsyncImage(model = article.imageUrl, contentDescription = article.title)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = article.title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = article.date, style = MaterialTheme.typography.bodySmall, modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(4.dp))
    }
}
