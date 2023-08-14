package com.weather.app.data.repository

import com.weather.app.data.client.NetworkClient
import com.weather.app.data.client.RequestType
import com.weather.app.data.client.buildRequest
import com.weather.app.data.response.CityWeatherResponse

class WeatherRemoteRepository(private val networkClient: NetworkClient) {

    suspend fun fetchCurrentWeather(city: String) =
        networkClient.request<CityWeatherResponse>(buildRequest {
            requestType = RequestType.GET
            path = "v1/current.json"
            queryParameter = mapOf("q" to city, "key" to "e998be1f247e4a618eb145912201712")
        })
}