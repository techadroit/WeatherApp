package com.weather.app.core

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseViewModel() {

    internal val scope: CoroutineScope

    fun clear()
}

