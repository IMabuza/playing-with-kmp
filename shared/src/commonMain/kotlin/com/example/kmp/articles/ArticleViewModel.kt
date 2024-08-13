package com.example.kmp.articles

import com.example.kmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel: BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState> = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {

            val fetchedArticles = fetchArticles()
            delay(700)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles(): List<Article>  = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Exploring the Depths of the Ocean",
            desc = "Afascinating journey into the mysteries of the deep sea, uncovering its hidden wonders and unique ecosystems.",
            date = "2023-11-15",
            imageUrl = "https://picsum.photos/id/1020/400/300"
        ),Article(
            title = "The Rise of Artificial Intelligence",
            desc = "A comprehensive look at the evolution of AI, its impact on society, and the ethical considerations surrounding its development.",
            date = "2023-11-10",
            imageUrl = "https://picsum.photos/id/1021/400/300"
        ),
        Article(
            title = "Sustainable Living: A Guide to Eco-Friendly Practices",
            desc = "Practical tips and insights on how to adopt a more sustainable lifestyle and reduce yourenvironmental footprint.",
            date = "2023-11-05",
            imageUrl = "https://picsum.photos/id/1022/400/300"
        ),
        Article(
            title = "The Future of Space Exploration",
            desc = "A glimpse into the exciting possibilities of space travel, from lunar colonies to interstellar missions.",
            date = "2023-11-01",
            imageUrl = "https://picsum.photos/id/1023/400/300"
        ),
        Article(
            title = "The Art of Mindfulness: Finding Peace in a Busy World",
            desc = "Techniques and practices to cultivate mindfulness and achieve a greater sense of calm and well-being.",
            date = "2023-10-28",
            imageUrl = "https://picsum.photos/id/1024/400/300"
        )
    )
}