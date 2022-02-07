package com.example.common_network.domain.entities

data class ResponseDataEntity(
        var url: String? = "",
        var method: String? = "",
        var statusCode: Int? = 0,
        var data: String? = "",
        var error: Error? = Error()
)

data class Error(
        var message: String = "",
        var body: String = ""
)
