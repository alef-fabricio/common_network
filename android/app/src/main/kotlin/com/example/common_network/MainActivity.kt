package com.example.common_network

import androidx.annotation.NonNull
import com.example.common_network.domain.usecases.*
import com.example.common_network.utils.Gson

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

enum class Method {
    GET, POST, PUT, DELETE, PATCH, DOWNLOAD,
}

class MainActivity : FlutterActivity() {
    private val CHANNEL = "io.unico.app/network"

    @ExperimentalStdlibApi
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            requestMethod(call, result)
        }
    }

    private fun requestMethod(call: MethodCall, result: MethodChannel.Result) {
        val requestBody = Gson().fromMap(call.arguments as Map<String, Any>)

        when {
            call.method.equals(Method.GET.name) -> {
                GetUseCase().get(requestBody, result)
            }
            call.method.equals(Method.POST.name) -> {
                PostUseCase().post(requestBody, result)
            }
            call.method.equals(Method.PUT.name) -> {
                PutUseCase().put(requestBody, result)
            }
            call.method.equals(Method.DELETE.name) -> {
                DeleteUseCase().delete(requestBody, result)
            }
            call.method.equals(Method.PATCH.name) -> {
                PatchUseCase().patch(requestBody, result)
            }
//            call.method.equals(Method.DOWNLOAD.name) -> {
//                DeleteUseCase().download(requestBody, result)
//            }
        }
    }
}