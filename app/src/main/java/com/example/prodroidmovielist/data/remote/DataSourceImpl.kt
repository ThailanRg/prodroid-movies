package com.example.prodroidmovielist.data.remote

import com.example.prodroidmovielist.core.utils.ACCEPT
import com.example.prodroidmovielist.core.utils.APPLICATION_JSON
import com.example.prodroidmovielist.core.utils.AUTHORIZATION
import com.example.prodroidmovielist.core.utils.BASE_URL
import com.example.prodroidmovielist.core.utils.LANGUAGE
import com.example.prodroidmovielist.core.utils.PAGE
import com.example.prodroidmovielist.core.utils.PT_BR
import com.example.prodroidmovielist.core.utils.TOKEN_READ_ONLY
import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.MoviesDto
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

class DataSourceImpl : DataSource {

    override suspend fun movies(page: String): MoviesDto {
        val httpClient = setupHttpClient()
        return httpClient.request(
            endpoint = END_POINT_LIST,
            page = page
        ).body<MoviesDto>()
    }

    override suspend fun movie(id: String): MovieDto {
        val httpClient = setupHttpClient()
        return httpClient.request(id).body<MovieDto>()
    }

    private suspend fun HttpClient.request(
        endpoint: String,
        page: String = ""
    ): HttpResponse {
        return this.get {
            url(endpoint)
            parameter(LANGUAGE, PT_BR)
            if (page.isNotEmpty()) parameter(PAGE, page)
        }
    }

    private fun setupHttpClient() = HttpClient(Android) {
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

    companion object {
        const val END_POINT_LIST = "popular"
    }

}
