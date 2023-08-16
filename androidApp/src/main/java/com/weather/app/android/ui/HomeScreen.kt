package com.weather.app.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.weather.app.presentation.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()){
    val state = viewModel.stateFlow.collectAsState().value
    state.currentWeather?.let { 
        Text(text = it.weatherCondition)
    }
}