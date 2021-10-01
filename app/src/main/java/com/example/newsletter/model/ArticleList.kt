package com.example.newsletter.model

data class ArticleList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)