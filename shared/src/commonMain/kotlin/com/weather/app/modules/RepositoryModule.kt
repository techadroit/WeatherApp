package com.weather.app.modules

import com.weather.app.data.repository.WeatherRemoteRepository
import com.weather.app.data.services.WeatherService
import org.koin.dsl.module

val serviceModule = module {
    single { WeatherService(get()) }
}

val repositoryModule = module {
    factory { WeatherRemoteRepository(get()) }
}