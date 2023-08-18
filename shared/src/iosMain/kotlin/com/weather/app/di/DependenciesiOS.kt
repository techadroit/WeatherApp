package com.weather.app.di

import com.weather.app.core.BaseViewModel
import com.weather.app.presentation.home.HomeViewModel
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

fun initKoinIos() = initKoin(listOf(engineModule))

object KoinDependency : KoinComponent{
    fun getHomeViewModel() = getKoin().get<HomeViewModel>()
}

internal actual inline fun <reified T : BaseViewModel> Module.viewModel(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = single(qualifier, definition = definition)

val engineModule = module {
    single<HttpClientEngine> { Darwin.create() }
}