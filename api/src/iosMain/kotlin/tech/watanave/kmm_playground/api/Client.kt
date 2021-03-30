package tech.watanave.kmm_playground.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.CoroutineContext

interface SearchWordProvider {

    val word: String

}

class IosClient: KoinComponent {

    val iosScope: CoroutineScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = SupervisorJob() + Dispatchers.Main
    }

    private val searchWordProvider: SearchWordProvider by inject()
    private val apiClient: ApiClient by inject()

    fun request() = NonNullSuspendWrapper {
        apiClient.request(searchWordProvider.word)
    }

}
