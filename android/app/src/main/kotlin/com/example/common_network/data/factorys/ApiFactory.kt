package com.example.common_network.data.factorys

import com.example.common_network.data.services.RetrofitService


object ApiFactory{
    fun retrofitService(baseUrl : String) : RetrofitService = RetrofitFactory.retrofit(baseUrl)
            .create(RetrofitService::class.java)
}

