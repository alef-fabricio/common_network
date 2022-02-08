package com.example.common_network.data.factorys
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory{

    private val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    fun retrofit(baseUrl : String) : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.plus("/"))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}