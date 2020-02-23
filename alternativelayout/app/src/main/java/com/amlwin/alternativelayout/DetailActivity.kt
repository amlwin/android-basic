package com.amlwin.alternativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_acitivity)

        val title = intent.getStringExtra(KEY_TITLE) ?: ""
        val body = intent.getStringExtra(KEY_BODY) ?: ""

        val detailFragment =
            supportFragmentManager.findFragmentByTag(DetailFragment.TAG_DETAIL_FRAGMENT)
                ?: DetailFragment.newInstance(title, body)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_detail_container, detailFragment, DetailFragment.TAG_DETAIL_FRAGMENT)
            .commit()
    }

    companion object {
        const val KEY_TITLE = "key_title"
        const val KEY_BODY = "key_body"
    }
}
