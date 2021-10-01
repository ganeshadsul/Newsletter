package com.example.newsletter.api

import com.example.newsletter.model.ArticleList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("/v2/everything")
    suspend fun getArticles(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey :String
    ): Response<ArticleList>
}