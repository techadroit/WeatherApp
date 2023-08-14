package com.weather.app.data.client

class RequestBuilder {
    lateinit var requestType: RequestType
    lateinit var path: String
    var queryParameter = emptyMap<String, String>()
    var pathParameter = emptyMap<String, String>()
}

fun buildRequest(block: RequestBuilder.() -> Unit): RequestBuilder {
    return RequestBuilder().apply { block() }
}
