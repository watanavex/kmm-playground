package tech.watanave.kmm_playground.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import platform.posix.free
import kotlin.native.concurrent.freeze

class NonNullSuspendWrapper<T: Any>(private val suspender: suspend () -> T) {
    init {
        freeze()
    }

    fun subscribe(
        scope: CoroutineScope,
        onSuccess: (result: T) -> Unit,
        onFailure: (error: Throwable) -> Unit) = scope.launch {
        runCatching {
            suspender()
        }.onSuccess {
            onSuccess(it.freeze())
        }.onFailure {
            onFailure(it.freeze())
        }
    }
}

class NullableSuspendWrapper<T>(private val suspender: suspend () -> T) {
    init {
        freeze()
    }

    fun subscribe(
        scope: CoroutineScope,
        onSuccess: (result: T) -> Unit,
        onFailure: (error: Throwable) -> Unit) = scope.launch {
        runCatching {
            suspender()
        }.onSuccess {
            onSuccess(it.freeze())
        }.onFailure {
            onFailure(it.freeze())
        }
    }
}

class NonNullFlowWrapper<T: Any>(private val flow: Flow<T>) {
    init {
        freeze()
    }

    fun subscribe(
        scope: CoroutineScope,
        onEach: (item: T) -> Unit,
        onComplete: () -> Unit = {},
        onFailure: (error: Throwable) -> Unit = {}
    ) = flow
        .onEach { onEach(it.freeze()) }
        .catch { onFailure(it.freeze()) }
        .onCompletion { onComplete() }
        .launchIn(scope)
        .freeze()
}

class NullableFlowWrapper<T>(private val flow: Flow<T>) {
    init {
        freeze()
    }

    fun subscribe(
        scope: CoroutineScope,
        onEach: (item: T) -> Unit,
        onComplete: () -> Unit = {},
        onFailure: (error: Throwable) -> Unit = {}
    ) = flow
        .onEach { onEach(it.freeze()) }
        .catch { onFailure(it.freeze()) }
        .onCompletion { onComplete() }
        .launchIn(scope)
        .freeze()
}
