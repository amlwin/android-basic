package com.amlwin.alternativelayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.view.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val KEY_TITLE = "key_title"
private const val KEY_BODY = "key_body"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private var titile: String? = null
    private var body: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titile = it.getString(KEY_TITLE)
            body = it.getString(KEY_BODY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tv_movie_title.text = titile
        view.tv_movie_body.text = body
    }


    companion object {

        const val TAG_DETAIL_FRAGMENT = "tag_detail_fragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param title Parameter 1.
         * @param body Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        @JvmStatic
        fun newInstance(title: String, body: String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_TITLE, title)
                putString(KEY_BODY, body)
            }
        }
    }
}
