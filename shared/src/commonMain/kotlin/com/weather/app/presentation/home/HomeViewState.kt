package com.weather.app.presentation.home

data class HomeViewState(
    val showLoading: Boolean = false,
    val currentWeather: WeatherInfo? = null,
    val forecastWeatherInfo: List<WeatherInfo> = emptyList()
)

fun HomeViewState.showLoading() = copy(showLoading = true)

fun HomeViewState.addCurrentWeather(currentWeather: WeatherInfo) =
    copy(showLoading = false, currentWeather = currentWeather)