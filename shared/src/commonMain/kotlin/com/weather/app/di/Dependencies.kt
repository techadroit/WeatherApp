package com.weather.app.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(modules: List<Module> = emptyList()) = startKoin {
    modules(modules + listOf(networkModule, repositoryModule))
}