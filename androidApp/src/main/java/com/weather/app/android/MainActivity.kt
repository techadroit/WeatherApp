package com.weather.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weather.app.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column {
                        Spacer(
                            Modifier.windowInsetsTopHeight(
                                WindowInsets.statusBars
                            )
                        )
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadData()
    }
    val state = viewModel.state.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        state.value.result?.onSuccess {
            TopView(cityName = it.city, temp = it.temp)
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(50.dp)
            )
        }
    }
}

@Composable
fun TopView(cityName: String, temp: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Text(text = temp, style = MaterialTheme.typography.h1)
        Text(text = cityName, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(62.dp))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
