package com.weather.app.core

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow

open class KViewModel<T>(initialState: T) : BaseViewModel() {
    private val _stateFlow = MutableStateFlow<T>(initialState)

    @NativeCoroutinesState
    val stateFlow = _stateFlow

    fun setState(block: T.() -> T) {
        val oldState = _stateFlow.value
        val newState = block(oldState)
        _stateFlow.value = newState
    }
}