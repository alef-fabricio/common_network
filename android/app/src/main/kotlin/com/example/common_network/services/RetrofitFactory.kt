package com.example.common_network.services
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory{

    fun retrofit(baseUrl : String) : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.plus("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}