package com.example.myapplication.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(val array: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieModel = array[position]
        Picasso.get().load(movieModel.picture).resize(130,200).into(holder.picture)
        holder.title.text=movieModel.title
        holder.date.text=movieModel.date
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val picture: ImageView = item.findViewById(R.id.picture)
        val title: TextView = item.findViewById(R.id.title)
        val date: TextView = item.findViewById(R.id.date)
    }
}