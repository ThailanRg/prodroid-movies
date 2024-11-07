package com.example.prodroidmovielist.data.remote

import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.MoviesDto

interface MoviesDataSource {
    suspend fun movies(page: String) : MoviesDto
    suspend fun movie(id: String) : MovieDto
}