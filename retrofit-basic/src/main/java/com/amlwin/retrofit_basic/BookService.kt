package com.amlwin.retrofit_basic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {

    @GET("books/{book_id}")
    fun getSpecificBookById(@Path("book_id") bookId: String): Call<BookResponse>
}