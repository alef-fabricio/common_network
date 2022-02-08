package com.example.common_network.utils

import com.example.common_network.domain.entities.ErrorEntity
import com.example.common_network.domain.entities.ResponseDataEntity
import okhttp3.ResponseBody
import retrofit2.Response

class ConvertResponse {

    fun convert(response: Response<ResponseBody>, method: String, url: String): String? {

        var errorEntity = ErrorEntity()

        if (!(response.code() in 200..300)) {
            errorEntity.message = response.message()
            errorEntity.body = response.errorBody().toString()
        }

        return Gson().objectToJson(ResponseDataEntity(
                url,
                method,
                response.code(),
                Gson().toJson(response),
                errorEntity) as Object)
    }
}