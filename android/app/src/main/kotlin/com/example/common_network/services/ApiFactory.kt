package com.example.common_network.services

object ApiFactory{
    fun retrofitService(baseUrl : String) : RetrofitService = RetrofitFactory.retrofit(baseUrl)
            .create(RetrofitService::class.java)
}