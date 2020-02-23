package com.amlwin.alternativelayout

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * a touch of amlwin on 2020-02-23.
 * made with <3
 */

class MovieAdapter(private val onClickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {
    private val data = mutableListOf<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false)
        return MovieViewHolder(itemView, onClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<Movie>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as MovieViewHolder).bind(data[position])
    }
}

