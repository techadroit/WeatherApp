package com.weather.app.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class BaseViewModel : ViewModel() {

    actual val scope: CoroutineScope = viewModelScope

    actual fun clear() {
        // no-op. AAC ViewModel is taking care of that
    }
}