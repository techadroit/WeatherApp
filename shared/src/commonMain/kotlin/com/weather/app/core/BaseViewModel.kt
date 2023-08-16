package com.weather.app.core

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

expect abstract class BaseViewModel() {

    internal val scope: CoroutineScope

    fun clear()
}

