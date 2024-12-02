package br.com.feat_movies.data.remote

import br.com.feat_movies.data.MoviesDto

interface MoviesDataSource {
    suspend fun movies(page: String) : MoviesDto
}