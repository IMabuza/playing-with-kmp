package com.example.kmp.articles.di

import com.example.kmp.articles.ArticlesService
import com.example.kmp.articles.ArticlesUseCase
import com.example.kmp.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}