package com.weather.app.presentation.home

import com.weather.app.core.KViewModel
import com.weather.app.core.collectIn
import com.weather.app.data.repository.WeatherRemoteRepository
import kotlinx.coroutines.launch

class HomeViewModel(val repository: WeatherRemoteRepository) : KViewModel<HomeViewState>(
    HomeViewState()
) {

    init {
        fetchCurrentWeather()
    }

    private fun fetchCurrentWeather() {
        setState {
            showLoading()
        }
        scope.launch {
            repository
                .fetchCurrentWeather("london")
                .collect {
                    setState {
                        addCurrentWeather(
                            WeatherInfo(
                                it?.current?.tempC ?: 0.0,
                                "london"
                            )
                        )
                    }
                }
        }
    }
}