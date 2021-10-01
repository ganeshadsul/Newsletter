package com.example.newsletter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsletter.model.ArticleList
import com.example.newsletter.repository.ArticleRepository
import kotlinx.coroutines.launch

class MainVIewModel(private val repository: ArticleRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getArticles(
                "tesla",
                "2021-09-30",
                "popularity",
                "1f473546521a4d5a8b69d8249ed13872"
            )
        }
    }
    val articles : LiveData<ArticleList>
    get() = repository.articles
}