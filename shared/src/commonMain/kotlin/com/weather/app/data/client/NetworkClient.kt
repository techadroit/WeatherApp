package com.weather.app.data.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class NetworkClient(
    val baseUrl: String = "api.weatherapi.com",
    val apiKey: String = "e998be1f247e4a618eb145912201712"
) {

    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    encodeDefaults = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend inline fun <reified T> performGet(
        builder: RequestBuilder
    ): T? = run {
        val urBuilder = HttpRequestBuilder().apply {
            url {
                protocol = URLProtocol.HTTPS
                host = baseUrl
                path(builder.path)
                builder.queryParameter.forEach {
                    parameters.append(it.key, it.value)
                }
            }
        }
        val response = client.get(urBuilder).handleResponse<T>()
        response
    }


    inline fun <reified T> request(
        builder: RequestBuilder
    ): Flow<T?> =
        flow {
            try {
                val response = when (builder.requestType) {
                    RequestType.GET -> performGet<T>(builder)
                    RequestType.POST -> null
                }
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
                throw e
            }
        }
}
