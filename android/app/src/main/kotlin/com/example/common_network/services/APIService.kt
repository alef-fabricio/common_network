package com.example.common_network.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface APIService {

    @GET(".")
    fun get(@HeaderMap headers: HashMap<String, Any>?): Call<ResponseBody>

}