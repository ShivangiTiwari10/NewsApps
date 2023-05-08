package com.example.newsapp

data class newsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)