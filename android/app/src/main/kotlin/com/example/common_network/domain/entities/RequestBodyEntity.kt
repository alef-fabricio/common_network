package com.example.common_network.domain.entities

data class RequestBodyEntity(
        var url: String,
        var body: String?,
        var options: Options
)

data class Options(
        var headers: HashMap<String, Any>?
)

