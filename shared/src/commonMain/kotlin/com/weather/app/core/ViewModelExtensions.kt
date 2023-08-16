package com.weather.app.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectIn(scope: CoroutineScope, crossinline action: suspend (value: T) -> Unit): Job =
    scope.launch {
        collect {
            action.invoke(it)
        }
    }

inline fun <T> Flow<T>.collectInScope(scope: CoroutineScope, crossinline action: suspend (value: T) -> Unit): Job =
    scope.launch {
        collect {
            action.invoke(it)
        }
    }