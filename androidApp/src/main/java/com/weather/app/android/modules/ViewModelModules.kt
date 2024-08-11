package com.weather.app.android.modules

import com.weather.app.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { MainViewModel(get()) }
}