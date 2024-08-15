package com.weather.app.viewmodel

import com.weather.app.data.response.CityWeatherResponse
import com.weather.app.data.response.ForecastWeatherResponse


data class WeatherInfo(val city: String, val temp: String)

data class WeatherState(
    val isLoading: Boolean = false,
    val result: Result<WeatherInfo>? = null,
    val foreCastResult: Result<List<WeatherInfo>?>? = null
)

fun WeatherState.loading() = copy(isLoading = true)

fun WeatherState.error() = copy(isLoading = false, result = Result.failure(Exception()))

fun WeatherState.success(res: CityWeatherResponse?) =
    copy(
        isLoading = false,
        result = Result.success(WeatherInfo(city, res?.current?.tempC.toString()))
    )

fun WeatherState.success(
    res: CityWeatherResponse?,
    forecastWeatherResponse: ForecastWeatherResponse?
) =
    copy(
        isLoading = false,
        result = Result.success(WeatherInfo(city, res?.current?.tempC.toString())),
        foreCastResult = Result.success(
            forecastWeatherResponse?.forecast?.forecastday?.map {
                WeatherInfo(
                    city = forecastWeatherResponse.location.name,
                    temp = it.day.avgtempC.toString()
                )
            }
        )
    )