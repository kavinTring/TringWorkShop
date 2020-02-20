package com.tring.tringworkshop.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIClient {

    private var gson = GsonBuilder().setLenient().create()
    val apiService: APIService

    init {
        apiService = Retrofit.Builder()
            .baseUrl(UrlHelper.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService::class.java)
    }

    /**
     * Create and return a new OkHttpClient to make the server communication with added timeout's
     */
    private fun createOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
        httpClientBuilder.writeTimeout(10, TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
        return httpClientBuilder.build()
    }
}