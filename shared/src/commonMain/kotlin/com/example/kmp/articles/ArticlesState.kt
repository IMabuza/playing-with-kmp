package com.example.kmp.articles

data class ArticlesState (
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)