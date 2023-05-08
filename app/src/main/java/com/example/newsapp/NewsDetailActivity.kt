package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.newsapp.databinding.ActivityNewsDetailBinding
import com.squareup.picasso.Picasso

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val heading = intent.getStringExtra("heading")
        val detail = intent.getStringExtra("content")
        val image = intent.getStringExtra("Image")
        val content = intent.getStringExtra("detail")

        val images = binding.imageView
        val headingTV = binding.textView2
        val contentText = binding.textView3
        val description = binding.Detail

        headingTV.text = heading
        contentText.text = content
        description.text = detail
        Picasso.get().load(image).into(images)


    }
}