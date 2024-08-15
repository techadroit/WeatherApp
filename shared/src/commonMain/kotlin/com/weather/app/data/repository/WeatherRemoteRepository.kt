package com.weather.app.data.repository

import com.weather.app.data.services.WeatherService

class WeatherRemoteRepository(private val apiService: WeatherService) {

    fun fetchCurrentWeather(city: String) = apiService.fetchCurrentWeather(city)

    fun fetchForecastWeather(city: String) = apiService.fetchForecastWeather(city)
}