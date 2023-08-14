package com.weather.app.data.client

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> HttpResponse.handleResponse() = body<T>()

