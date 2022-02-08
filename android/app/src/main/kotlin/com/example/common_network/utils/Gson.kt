package com.example.common_network.utils

import com.example.common_network.domain.entities.RequestBodyEntity
import com.example.common_network.domain.entities.ResponseDataEntity
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Response

class Gson {
    val gson = GsonBuilder().setPrettyPrinting().create()

    fun toJson(response: Response<ResponseBody>): String? {
        return if(response.body() != null){
            gson.toJson(JsonParser.parseString(response.body()?.string()))
        }else{
            ""
        }
    }

    fun objectToJson(obj: Object): String? {
        return gson.toJson(obj)
    }

    fun fromMap(map: Map<String, Any>): RequestBodyEntity {
        return map.toDataClass() as RequestBodyEntity
    }

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