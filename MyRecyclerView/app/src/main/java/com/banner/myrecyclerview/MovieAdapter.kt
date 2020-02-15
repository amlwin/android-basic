package com.banner.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_list_row.view.*

/**
 * a touch of aungmyolwin on 2019-07-04.
 * made with <3
 */
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private val movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_row, parent, false)
        return MyViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setMovieList(movieData: List<Movie>) {
        this.movieList.addAll(movieData)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.title.text = movie.title
            itemView.genre.text = movie.genre
            itemView.year.text = movie.year
        }
    }
}
