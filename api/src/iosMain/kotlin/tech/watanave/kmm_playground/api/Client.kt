package tech.watanave.kmm_playground.api

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual fun provideHttpClient() : HttpClient = HttpClient(Ios) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(ApiCommon.provideJson())
    }
}
