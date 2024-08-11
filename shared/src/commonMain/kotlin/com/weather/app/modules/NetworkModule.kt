package com.weather.app.modules

import com.weather.app.data.client.NetworkClient
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClient() }
}