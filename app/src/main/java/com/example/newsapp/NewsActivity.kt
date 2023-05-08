package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.ActivityNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private lateinit var myadapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
            .create(NewsApiInterface::class.java)
        val retrofitData = retrofitBuilder.getNewsData()

        retrofitData.enqueue(object : Callback<newsData?> {
            override fun onResponse(call: Call<newsData?>, response: Response<newsData?>) {

                val responceBody = response.body()
                val articleList = responceBody?.articles
                myadapter = NewsAdapter(this@NewsActivity, articleList!!)
                binding.myRecycler.adapter = myadapter

                binding.myRecycler.layoutManager = LinearLayoutManager(this@NewsActivity)
    }
            override fun onFailure(call: Call<newsData?>, t: Throwable) {

                Log.d("MyRetrofitActivity", "onFailure ${t.message}")
            }
        })


}}