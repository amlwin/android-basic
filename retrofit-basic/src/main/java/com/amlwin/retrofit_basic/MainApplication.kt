package com.amlwin.retrofit_basic

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class MainApplication : Application() {
    private val baseUrl = "https://api.itbook.store/1.0/"

    lateinit var bookApiService: BookService
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        setupBookApi()
    }

    fun setupBookApi() {
        bookApiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BookService::class.java)
    }

    fun testMain() = "TestString"
}