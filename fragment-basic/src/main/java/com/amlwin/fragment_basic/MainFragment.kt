package com.amlwin.fragment_basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * a touch of amlwin on 02/04/2020.
 * made with <3
 */

class MainFragment : Fragment(R.layout.fragment_main) {
    companion object {
        const val tag = "tag_main_fragment"
        const val key_title = "key_title"
        private const val keyTitleDefaultValue = "key_title_default_value"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.tv_title.text = it.getString(key_title, keyTitleDefaultValue)
        }
    }
}