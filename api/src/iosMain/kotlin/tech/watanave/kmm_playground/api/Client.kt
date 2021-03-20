package tech.watanave.kmm_playground.api

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

class IosClient(private val apiClient: ApiClient) {

    val scope: CoroutineScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = SupervisorJob() + Dispatchers.Default
    }

    fun requestFlow(searchWord: String) = NonNullFlowWrapper(flow {
        emit(apiClient.request(searchWord))
    })

    fun request(searchWord: String) = NonNullSuspendWrapper {
        apiClient.request(searchWord)
    }

}

actual fun provideHttpClient() : HttpClient = HttpClient(Ios) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(ApiCommon.provideJson())
    }
}
