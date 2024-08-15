package com.weather.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.data.repository.WeatherRemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.zip
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
                .zip(repository.fetchForecastWeather(city)) { t1, t2 ->
                    t1 to t2
                }.onStart {
                    state.update { it.loading() }
                }
                .catch {
                    state.update {
                        it.error()
                    }
                }
                .collect { res ->
                    state.update {
                        it.success(res.first, res.second)
                    }
                }
        }
    }
}
