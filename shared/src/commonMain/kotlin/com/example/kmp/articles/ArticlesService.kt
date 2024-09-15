package com.example.kmp.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val client: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "122bc802b7cc4482940f97164467a9e4"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticleResponse =
            client.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }
}