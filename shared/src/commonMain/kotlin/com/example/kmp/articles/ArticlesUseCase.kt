package com.example.kmp.articles

class ArticlesUseCase(private val service: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        val response = service.fetchArticles()
        return mapArticles(response)

    }

    private fun mapArticles(response: List<ArticleRaw>): List<Article> {
        return response.map {
            Article(
                title = it.title,
                desc = it.desc ?: "Fuck the description, I guess",
                date = it.date,
                imageUrl = it.imageUrl ?: "https://picsum.photos/id/1020/400/300"
            )
        }

    }
}