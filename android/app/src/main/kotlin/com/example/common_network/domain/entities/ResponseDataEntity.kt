package com.example.common_network.domain.entities

data class ResponseDataEntity(
        var url: String? = "",
        var method: String? = "",
        var statusCode: Int? = 0,
        var data: String? = "",
        var error: ErrorEntity? = ErrorEntity()
)

data class ErrorEntity(
        var message: String? = "",
        var body: String? = ""
)
