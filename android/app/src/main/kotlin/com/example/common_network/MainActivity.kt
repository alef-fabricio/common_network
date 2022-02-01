package com.example.common_network

import androidx.annotation.NonNull
import com.example.common_network.services.APIService
import com.example.common_network.utils.Util

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

enum class Method {
    GET, POST, PUT, DELETE
}

class MainActivity : FlutterActivity() {
    private val CHANNEL = "io.unico.app/network"

    @ExperimentalStdlibApi
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            request(call, result)
        }
    }

    private fun request(call: MethodCall, result: MethodChannel.Result) {
        when {
            call.method.equals(Method.GET.name) -> {
                get(call, result)
            }
            call.method.equals(Method.POST.name) -> {
                post(call, result)
            }
            call.method.equals(Method.PUT.name) -> {
                put(call, result)
            }
            call.method.equals(Method.DELETE.name) -> {
                delete(call, result)
            }
        }
    }

    private fun get(call: MethodCall, result: MethodChannel.Result) {
        var url = call.argument<String>("url")
        var headers = call.argument<HashMap<String, Any>?>("options")?.getValue("headers") as HashMap<String, Any>?

        val service = Retrofit.Builder()
                .baseUrl(url.plus("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)

        val callback = service.get(headers)

        callback.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                result.error(t?.localizedMessage, t?.message, t?.cause)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                result.success(Util().toJson(response))
            }
        })

    }

    private fun post(call: MethodCall, result: MethodChannel.Result) {
        var color = call.argument<String>("body");
        result.success(color);
    }

    private fun put(call: MethodCall, result: MethodChannel.Result) {
        var color = call.argument<String>("body");
        result.success(color);
    }

    private fun delete(call: MethodCall, result: MethodChannel.Result) {
        var color = call.argument<String>("body");
        result.success(color);
    }

}


//        val retrofit = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .build()
//
//        val service = retrofit.create(APIService::class.java)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.get(options)
//
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    val gson = GsonBuilder().setPrettyPrinting().create()
//                    val json = gson.toJson(
//                            JsonParser.parseString(
//                                    response.body()
//                                            ?.string()
//                            )
//                    )
//
//                    Log.d("Pretty Printed JSON :", json)
//                } else {
//                    Log.e("RETROFIT_ERROR", response.code().toString())
//                }
//            }
//            }