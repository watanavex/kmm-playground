package tech.watanave.kmm_playground.api

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual fun provideHttpClient() : HttpClient = HttpClient(Android) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(ApiCommon.provideJson())
    }
}
