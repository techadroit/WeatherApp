package com.weather.app.data.services

import com.weather.app.data.client.NetworkClient
import com.weather.app.data.client.RequestType
import com.weather.app.data.client.buildRequest
import com.weather.app.data.response.CityWeatherResponse
import com.weather.app.data.response.ForecastWeatherResponse

class WeatherService(private val networkClient: NetworkClient) {

    val CURRENT_API_PATH = "v1/current.json"
    val FORECAST_API_PATH = "v1/forecast.json"

    fun fetchCurrentWeather(city: String) =
        networkClient.request<CityWeatherResponse>(buildRequest {
            requestType = RequestType.GET
            path = CURRENT_API_PATH
            queryParameter = buildParameter(city, networkClient.apiKey)
        })

    fun fetchForecastWeather(city: String) =
        networkClient.request<ForecastWeatherResponse>(buildRequest {
            requestType = RequestType.GET
            path = FORECAST_API_PATH
            queryParameter = buildParameter(city, networkClient.apiKey)
        })

    private fun buildParameter(city: String, key: String) = mapOf("q" to city, "key" to key)
}