package com.example.common_network.utils

import com.example.common_network.domain.entities.RequestBodyEntity
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Response

class Gson {
    val gson = GsonBuilder().setPrettyPrinting().create()

    fun toJson(response: Response<ResponseBody>): String? {
        return gson.toJson(JsonParser.parseString(response.body()?.string()))
    }

    fun fromMap(map: Map<String, Any>): RequestBodyEntity {
        return map.toDataClass() as RequestBodyEntity
    }

//    fun fromMap(map: HashMap<String, Any>): RequestBodyModel? {
//        return gson.fromJson(gson.toJsonTree(map), RequestBodyModel::class.java)
//    }


    //convert a map to a data class
    inline fun <reified T> Map<String, Any>.toDataClass(): T {
        return convert()
    }

    //convert a data class to a map
    fun <T> T.serializeToMap(): Map<String, Any> {
        return convert()
    }

    //convert an object of type I to type O
    inline fun <I, reified O> I.convert(): O {
        val json = gson.toJson(this)
        return gson.fromJson(json, object : TypeToken<O>() {}.type)
    }

}