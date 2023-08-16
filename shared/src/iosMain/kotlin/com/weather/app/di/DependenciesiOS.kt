package com.weather.app.di

import com.weather.app.presentation.home.HomeViewModel
import org.koin.core.component.KoinComponent

fun initKoinIos() = initKoin()

object KoinDependency : KoinComponent{
    fun getHomeViewModel() = getKoin().get<HomeViewModel>()
}