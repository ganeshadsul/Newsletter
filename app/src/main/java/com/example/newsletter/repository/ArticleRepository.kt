package com.example.newsletter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsletter.api.ArticleService
import com.example.newsletter.model.ArticleList

// to access api through articleService
class ArticleRepository(private val articleService: ArticleService) {

    private val articleLiveData = MutableLiveData<ArticleList>()

    val articles :LiveData<ArticleList>
    get() = articleLiveData
    suspend fun getArticles (q : String, from : String, sortBy : String, apiKey : String){
        val article = articleService.getArticles(q, from, sortBy, apiKey)
        if (article?.body() != null){
            articleLiveData.postValue(article.body())
        }
    }
}