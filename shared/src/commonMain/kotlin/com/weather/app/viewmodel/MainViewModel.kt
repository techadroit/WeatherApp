package com.weather.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.data.repository.WeatherRemoteRepository
import com.weather.app.data.response.CityWeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

const val city = "london"

class MainViewModel(val repository: WeatherRemoteRepository) : ViewModel() {

    val state = MutableStateFlow(WeatherState())

    fun loadData() {
        fetchCityWeather(city)
    }

    private fun fetchCityWeather(city: String) {
        viewModelScope.launch {
            repository.fetchCurrentWeather(city)
                .onStart {
                    state.update { it.loading() }
                }
                .collect { res ->
                    println(" the response is ${res?.current}")
                    state.update {
                        it.success(res)
                    }
                }
        }
    }
}

data class WeatherInfo(val city: String, val temp: String)

data class WeatherState(val isLoading: Boolean = false, val result: Result<WeatherInfo>? = null)

fun WeatherState.loading() = copy(isLoading = true)

fun WeatherState.success(res: CityWeatherResponse?) =
    copy(
        isLoading = false,
        result = Result.success(WeatherInfo(city, res?.current?.tempC.toString()))
    )