package com.example.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsletter.api.ArticleService
import com.example.newsletter.api.RetrofitHelper
import com.example.newsletter.api.RetrofitHelper.getInstance
import com.example.newsletter.repository.ArticleRepository
import com.example.newsletter.viewmodels.MainVIewModel
import com.example.newsletter.viewmodels.MainVIewModelFactory
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainVIewModel: MainVIewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articleService = RetrofitHelper.getInstance().create(ArticleService::class.java)
        val repository= ArticleRepository(articleService)

        mainVIewModel = ViewModelProvider(this, MainVIewModelFactory(repository)).get(MainVIewModel::class.java )

        mainVIewModel.articles.observe(this, Observer {
            Log.d("ArticleList", it.articles.toString())
        })

    }

}