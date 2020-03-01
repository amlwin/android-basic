package com.amlwin.retrofit_basic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var mainApplication: MainApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainApplication = (this.applicationContext as MainApplication)


        Timber.d("test string : ${mainApplication.testMain()}")

        val call = mainApplication.bookApiService.getSpecificBookById("9781617294136")

        showLoading(true)

        call.enqueue(object : Callback<BookResponse> {
            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                showLoading(false)
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                showLoading(false)
                if (response.isSuccessful) {
                    val bookResponse = response.body()

                    tv_book_title.text = bookResponse?.title
                    tv_book_subtitle.text = bookResponse?.subtitle
                }
            }

        })

    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            pb_loading.visibility = View.VISIBLE
            cl_root_layout.visibility = View.GONE
        } else {
            pb_loading.visibility = View.GONE
            cl_root_layout.visibility = View.VISIBLE
        }
    }
}
