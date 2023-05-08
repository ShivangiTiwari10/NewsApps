package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET

interface NewsApiInterface {

    @GET("top-headlines?sources=techcrunch&apiKey=f188918394af479e9e2014da3d0ba285")
    fun getNewsData(): Call<newsData>
}