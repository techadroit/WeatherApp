package com.weather.app

import com.weather.app.data.client.NetworkClient
import com.weather.app.data.repository.WeatherRemoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet() {
        performNetwork()
        "Hello, ${platform.name}!"
    }

    fun performNetwork() {
        GlobalScope.launch {
            val client = NetworkClient()
            val repository = WeatherRemoteRepository(client)
            repository.fetchCurrentWeather("london")
                .collect {
                    println(" the response is ${it?.current}")
                }
        }
    }
}