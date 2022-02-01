package com.example.common_network.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.ResponseBody
import retrofit2.Response

class Util {
    val gson = GsonBuilder().setPrettyPrinting().create()

    fun toJson(response: Response<ResponseBody>): String? {
        return gson.toJson(JsonParser.parseString(response.body()?.string()))
    }

//    fun fromJSON(response: Response<ResponseBody>): String? {
//        return gson.fromJson(JsonParser.parseString(response.body()?.string()))
//    }
}