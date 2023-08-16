package com.weather.app.core

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

actual abstract class BaseViewModel {

    @NativeCoroutineScope
    actual val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    actual fun clear() {
        scope.cancel()
    }
}