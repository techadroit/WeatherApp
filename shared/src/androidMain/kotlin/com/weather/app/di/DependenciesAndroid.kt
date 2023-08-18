package com.weather.app.di

import com.weather.app.core.BaseViewModel
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel as koinViewModel

internal actual inline fun <reified T : BaseViewModel> Module.viewModel(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = koinViewModel(qualifier,definition)

val engineModule = module {
    single<HttpClientEngine> { OkHttp.create() }
}