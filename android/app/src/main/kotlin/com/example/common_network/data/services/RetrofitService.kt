package com.example.common_network.data.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @GET(".")
    fun get(@HeaderMap headers: HashMap<String, Any>?): Call<ResponseBody>

    @POST(".")
    fun post(@HeaderMap headers: HashMap<String, Any>?, @Body body: String?): Call<ResponseBody>

}