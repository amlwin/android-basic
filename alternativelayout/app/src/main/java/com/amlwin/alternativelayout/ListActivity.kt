package com.amlwin.alternativelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    private val data: MutableList<Movie> = mutableListOf()
    private lateinit var adapter: MovieAdapter

    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (fl_detail_container != null) {
            // The detail container view will be present only in the
            // in landscape
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        prepareMovieData()
        prepareRecycler()
    }

    private fun prepareRecycler() {
        adapter = MovieAdapter { movie ->
            if (twoPane) {
                val detailFragment =
                    supportFragmentManager.findFragmentByTag(DetailFragment.TAG_DETAIL_FRAGMENT)
                        ?: DetailFragment.newInstance(movie.title, movie.body)


                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_detail_container, detailFragment)
                    .commit()

            } else {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.KEY_BODY, movie.body)
                intent.putExtra(DetailActivity.KEY_TITLE, movie.title)
                startActivity(intent)
            }
        }
        rv_movie_list.addItemDecoration(DividerItemDecoration(this, RecyclerView.HORIZONTAL))
        rv_movie_list.adapter = adapter
        adapter.setData(data)
    }

    private fun prepareMovieData() {
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure")
        data.add(movie)

        movie = Movie("Inside Out", "Animation, Kids & Family")
        data.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action")
        data.add(movie)

        movie = Movie("Shaun the Sheep", "Animation")
        data.add(movie)

        movie = Movie("The Martian", "Science Fiction & Fantasy")
        data.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", "Action")
        data.add(movie)

        movie = Movie("Up", "Animation")
        data.add(movie)

        movie = Movie("Star Trek", "Science Fiction")
        data.add(movie)

        movie = Movie("The LEGO Movie", "Animation")
        data.add(movie)

        movie = Movie("Iron Man", "Action & Adventure")
        data.add(movie)

        movie = Movie("Aliens", "Science Fiction")
        data.add(movie)

        movie = Movie("Chicken Run", "Animation")
        data.add(movie)

        movie = Movie("Back to the Future", "Science Fiction")
        data.add(movie)

        movie = Movie("Raiders of the Lost Ark", "Action & Adventure")
        data.add(movie)

        movie = Movie("Goldfinger", "Action & Adventure")
        data.add(movie)

        movie = Movie("Guardians of the Galaxy", "Science Fiction & Fantasy")
        data.add(movie)
    }
}
