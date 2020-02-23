package com.amlwin.alternativelayout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_movie.view.*

/**
 * a touch of amlwin on 2020-02-23.
 * made with <3
 */

class MovieViewHolder(itemView: View, onClickListener: (Movie) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private lateinit var data: Movie

    init {
        itemView.setOnClickListener {
            onClickListener(data)
        }
    }

    fun bind(movie: Movie) {
        data = movie
        itemView.tv_movie_title.text = data.title
    }
}