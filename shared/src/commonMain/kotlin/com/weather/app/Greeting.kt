package com.weather.app

import com.weather.app.data.NetworkClient
import com.weather.app.data.RequestType
import com.weather.app.data.response.CityWeatherResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet() {
        performNetwork()
         "Hello, ${platform.name}!"
    }

    fun performNetwork(){
        GlobalScope.launch {
            val client = NetworkClient()
//            val response = client.performGet("v1/current.json", mapOf("q" to "london"))
            val response = client.request<CityWeatherResponse>(RequestType.GET,"v1/current.json", mapOf("q" to "london"))
            println(" the response is ${response?.current}")
        }
    }
}