package com.example.common_network.domain.repositories

import com.example.common_network.domain.entities.RequestBodyEntity
import io.flutter.plugin.common.MethodChannel

interface GetRepository {
    fun get(requestBodyEntity: RequestBodyEntity, result: MethodChannel.Result)
}