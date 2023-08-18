package com.weather.app.di

import com.weather.app.core.BaseViewModel
import com.weather.app.presentation.home.HomeViewModel
import org.koin.core.context.startKoin
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

fun initKoin(modules: List<Module> = emptyList()) = startKoin {
    modules(modules + listOf(networkModule, repositoryModule,viewModelModule))
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

internal expect inline fun <reified T : BaseViewModel> Module.viewModel(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>,
): KoinDefinition<T>