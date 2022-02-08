package com.example.common_network.data.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET(".")
    fun get(@HeaderMap headers: HashMap<String, Any>?): Call<ResponseBody>

    @DELETE(".")
    fun delete(@HeaderMap headers: HashMap<String, Any>?): Call<ResponseBody>

    @POST(".")
    fun post(@HeaderMap headers: HashMap<String, Any>?, @Body body: HashMap<String, Any>?): Call<ResponseBody>

    @PUT(".")
    fun put(@HeaderMap headers: HashMap<String, Any>?, @Body body: HashMap<String, Any>?): Call<ResponseBody>

    @PATCH(".")
    fun patch(@HeaderMap headers: HashMap<String, Any>?, @Body body: HashMap<String, Any>?): Call<ResponseBody>

}