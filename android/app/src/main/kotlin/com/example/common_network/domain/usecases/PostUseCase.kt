package com.example.common_network.domain.usecases

import com.example.common_network.services.RetrofitService
import com.example.common_network.domain.entities.RequestBodyEntity
import com.example.common_network.utils.Gson
import io.flutter.plugin.common.MethodChannel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostUseCase {
     fun post(requestBodyEntity: RequestBodyEntity, result: MethodChannel.Result) {

        val service = Retrofit.Builder()
                .baseUrl(requestBodyEntity.url.plus("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)

        val callback = service.post(requestBodyEntity.options.headers, requestBodyEntity.body)

        callback.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                result.error(t.localizedMessage, t.message, t.cause)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                result.success(Gson().toJson(response))
            }
        })
    }
}