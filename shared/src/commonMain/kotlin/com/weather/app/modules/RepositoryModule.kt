package com.weather.app.modules

import com.weather.app.data.repository.WeatherRemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { WeatherRemoteRepository(get()) }
}