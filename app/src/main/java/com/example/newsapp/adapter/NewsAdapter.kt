package com.example.newsapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R

class NewsAdapter(val context: Activity) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.news_items, parent, false)
        return NewsViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}