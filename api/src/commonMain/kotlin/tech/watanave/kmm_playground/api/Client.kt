package tech.watanave.kmm_playground.api

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import tech.watanave.kmm_playground.model.Response

class ApiClient {

    private val httpClient: HttpClient = provideHttpClient()

    suspend fun request(searchWord: String) : Response {

        // TODO: URL encoding
        return httpClient.get("https://api.github.com/search/repositories?q=$searchWord")
    }
}

object ApiCommon {
    fun provideJson() : Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }
}

expect fun provideHttpClient() : HttpClient
