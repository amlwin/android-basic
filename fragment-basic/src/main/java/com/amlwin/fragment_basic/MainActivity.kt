package com.amlwin.fragment_basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    val mainFragmentFactory = MainFragmentFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = mainFragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = Bundle()
        bundle.putString(MainFragment.tag, getString(R.string.title_main_fragment))

        supportFragmentManager.commit {
            replace(R.id.frag_container, MainFragment::class.java, bundle, MainFragment.tag)
        }
    }
}
