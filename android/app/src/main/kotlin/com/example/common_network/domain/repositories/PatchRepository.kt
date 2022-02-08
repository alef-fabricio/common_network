package com.example.common_network.domain.repositories

import com.example.common_network.domain.entities.RequestBodyEntity
import io.flutter.plugin.common.MethodChannel

interface PatchRepository {
    fun patch(requestBodyEntity: RequestBodyEntity, result: MethodChannel.Result)
}