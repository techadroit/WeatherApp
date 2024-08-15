package com.weather.app.viewmodel

import com.weather.app.data.response.CityWeatherResponse
import com.weather.app.data.response.ForecastWeatherResponse
import kotlinx.datetime.LocalDate


data class WeatherInfo(val city: String, val temp: String)
data class WeatherForecast(val day: String, val temp: String)

data class WeatherState(
    val isLoading: Boolean = false,
    val result: Result<WeatherInfo>? = null,
    val foreCastResult: Result<List<WeatherForecast>?>? = null
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
): WeatherState {
    val forecastList = forecastWeatherResponse?.forecast?.forecastday?.map {
        WeatherForecast(
            day = getDayOfWeek(it.date),
            temp = it.day.avgtempC.toString()
        )
    }
    return copy(
        isLoading = false,
        result = Result.success(WeatherInfo(city, res?.current?.tempC.toString())),
        foreCastResult = Result.success(
            forecastList
        )
    )
}

fun getDayOfWeek(dateString: String): String {
    val date = LocalDate.parse(dateString)
    return date.dayOfWeek.name  // Returns the day of the week as a string, e.g., "THURSDAY"
}