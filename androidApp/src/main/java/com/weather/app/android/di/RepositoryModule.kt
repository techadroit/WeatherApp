package com.weather.app.android.di

import com.weather.app.data.repository.WeatherRemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRemoteRepository(get()) }
}