package br.com.feat_movie.data.remote

import br.com.feat_movie.data.model.MovieDto

interface MovieDataSource {
    suspend fun movie(id: String): MovieDto
}