package br.com.core_network

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

suspend inline fun <reified T> getRequest(
    endpoint: String,
    page: String = "",
): T {
    val httpClient = setupHttpClient()
    return httpClient.request(
        endpoint = endpoint,
        page = page
    ).body<T>()
}

suspend fun HttpClient.request(
    endpoint: String = "",
    page: String = "",
): HttpResponse {
    return this.get {
        url(endpoint)
        parameter(LANGUAGE, PT_BR)
        if (page.isNotEmpty()) parameter(PAGE, page)
    }
}

fun setupHttpClient() = HttpClient(Android) {
    install(Logging) {
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    defaultRequest {
        url(BASE_URL)
        header(ACCEPT, APPLICATION_JSON)
        header(AUTHORIZATION, TOKEN_READ_ONLY)
    }
    install(HttpRequestRetry) {
        retryOnServerErrors(maxRetries = 3)
        retryIf { _, response ->
            !response.status.isSuccess()
        }
        exponentialDelay()
    }
}