package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val activityScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        activityScope.launch {
            delay(2000)


            finish()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

}