package com.example.newsletter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsletter.repository.ArticleRepository

class MainVIewModelFactory(private val repository: ArticleRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainVIewModel(repository) as T
    }
}