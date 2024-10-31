package com.example.prodroidmovielist.data.remote

import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.MoviesDto

interface DataSource {
    suspend fun movies(page: String = "1"): MoviesDto
    suspend fun movie(id: String = "1"): MovieDto
}