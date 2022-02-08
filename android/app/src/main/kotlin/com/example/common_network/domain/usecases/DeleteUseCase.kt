package com.example.common_network.domain.usecases

import com.example.common_network.Method
import com.example.common_network.data.factorys.ApiFactory
import com.example.common_network.domain.entities.RequestBodyEntity
import com.example.common_network.domain.repositories.DeleteRepository
import com.example.common_network.utils.ConvertResponse
import io.flutter.plugin.common.MethodChannel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteUseCase: DeleteRepository {
    override fun delete(requestBodyEntity: RequestBodyEntity, result: MethodChannel.Result) {

        val service = ApiFactory.retrofitService(requestBodyEntity.url)
        val callback = service.delete(requestBodyEntity.options.headers)

        callback.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                result.error(t.localizedMessage, t.message, t.cause)
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                result.success(ConvertResponse().convert(response, Method.DELETE.name, requestBodyEntity.url))
            }
        })
    }
}