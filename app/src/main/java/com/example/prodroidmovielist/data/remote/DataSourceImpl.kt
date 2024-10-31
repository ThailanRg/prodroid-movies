package com.example.prodroidmovielist.data.remote

import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.MoviesDto
import com.example.prodroidmovielist.utils.ACCEPT
import com.example.prodroidmovielist.utils.APPLICATION_JSON
import com.example.prodroidmovielist.utils.AUTHORIZATION
import com.example.prodroidmovielist.utils.BASE_URL
import com.example.prodroidmovielist.utils.EN_US
import com.example.prodroidmovielist.utils.LANGUAGE
import com.example.prodroidmovielist.utils.PAGE
import com.example.prodroidmovielist.utils.TOKEN_READ_ONLY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DataSourceImpl : DataSource {

    override suspend fun movies(page: String): MoviesDto {
        val httpClient = setupHttpClient(block = { header(PAGE, page) })
        return httpClient.get("$BASE_URL/popular").body<MoviesDto>()
    }

    override suspend fun movie(id: String): MovieDto {
        val httpClient = setupHttpClient()
        return httpClient.get("$BASE_URL/$id").body<MovieDto>()
    }

    private fun setupHttpClient(
        block: DefaultRequest.DefaultRequestBuilder.() -> Unit = {}
    ) = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        defaultRequest {
            header(ACCEPT, APPLICATION_JSON)
            header(AUTHORIZATION, TOKEN_READ_ONLY)
            header(LANGUAGE, EN_US)
            block()
        }
    }

}
