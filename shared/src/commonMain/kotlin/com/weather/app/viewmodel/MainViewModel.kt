package com.weather.app.viewmodel

import androidx.lifecycle.ViewModel
import com.weather.app.data.client.NetworkClient
import com.weather.app.data.repository.WeatherRemoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(val repository: WeatherRemoteRepository) : ViewModel() {

    val state = MutableStateFlow(WeatherState())

    fun loadData() {
        performNetwork()
    }

    fun performNetwork() {
        GlobalScope.launch {
//            val client = NetworkClient()
//            val repository = WeatherRemoteRepository(client)
            repository.fetchCurrentWeather("london")
                .collect { res ->
                    println(" the response is ${res?.current}")
                    state.update {
                        it.copy(city = "london", temp = res?.current?.tempC.toString())
                    }
                }
        }
    }
}

data class WeatherState(val city: String? = null, val temp: String? = null)