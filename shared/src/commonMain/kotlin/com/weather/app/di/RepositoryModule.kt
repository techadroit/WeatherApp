package com.weather.app.di

import com.weather.app.data.repository.WeatherRemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRemoteRepository(get()) }
}