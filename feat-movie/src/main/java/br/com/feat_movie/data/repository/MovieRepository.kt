package br.com.feat_movie.data.repository

import br.com.feat_movie.data.model.MovieDto

interface MovieRepository {
    suspend fun movie(id:String): MovieDto
}