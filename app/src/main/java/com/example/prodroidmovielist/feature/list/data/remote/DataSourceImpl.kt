package com.example.prodroidmovielist.feature.list.data.remote

import android.util.Log
import com.example.prodroidmovielist.feature.list.data.model.MoviesDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DataSourceImpl : DataSource {

    override suspend fun getList(): List<MoviesDto> {
        val httpClient = HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                header("accept", "application/json")
                header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkYjMxMzFmYWNjMGUwMTcyZTE5Y2I3OWE3NDBjYjk3OCIsIm5iZiI6MTczMDMyMzMwNy43NDQ5ODk2LCJzdWIiOiI2NzIyYTE5ZTgyNmZlNTc5OWNjNGMzODgiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.CTFlu2AnFKALAH9FJY4F7O2mC-DZhWvlfWHCOd4BByQ")
            }
        }

        val result = httpClient.get("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1").body<MoviesDto>()
        Log.d("meu_resultado", "getList: ${result}")
        return emptyList()
    }

}
