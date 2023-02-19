package com.myapplication.fordmarvel

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapplication.fordmarvel.Result
import com.myapplication.fordmarvel.databinding.RowBinding

class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<Result>()

    fun setMovies(movies: List<Result>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

       val inflater = LayoutInflater.from(parent.context)
        val binding = RowBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
            holder.binding.textView.text = movie.name
            //Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
      //  Log.i("data", ""+movieList.size)
        return movieList.size

    }
}

class MainViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {

}