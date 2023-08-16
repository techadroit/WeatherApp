package com.weather.app.android.di

import com.weather.app.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

//    single { HomeViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}