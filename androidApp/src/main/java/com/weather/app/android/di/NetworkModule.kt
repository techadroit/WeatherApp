package com.weather.app.android.di

import com.weather.app.data.client.NetworkClient
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClient() }
}