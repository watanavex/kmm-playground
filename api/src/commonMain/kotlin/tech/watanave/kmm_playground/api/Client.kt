package tech.watanave.kmm_playground.api

import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import tech.watanave.kmm_playground.model.Response

class ApiClient(private val httpClient: HttpClient): KoinComponent {

    suspend fun request(searchWord: String) : Response {

        // TODO: URL encoding
        return httpClient.get("https://api.github.com/search/repositories?q=$searchWord")
    }
}

