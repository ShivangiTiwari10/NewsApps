package com.example.newsapp.adapter


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Article
import com.example.newsapp.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class NewsAdapter(private val context: Activity, val newsArrayList: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.news_items, parent, false)
        return NewsViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.title.text = currentItem.title
        holder.detail.text = currentItem.description

        Picasso.get().load(currentItem.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val image: ShapeableImageView
        val detail: TextView

        init {
            title = itemView.findViewById(R.id.NewsTitle)
            image = itemView.findViewById(R.id.productImage)
            detail = itemView.findViewById(R.id.newsDetail)
        }

    }

}