package com.example.prodroidmovielist.data.repository

import com.example.prodroidmovielist.data.model.movie.MovieDto
import com.example.prodroidmovielist.data.model.movies.MoviesDto

interface Repository {
    suspend fun movies(): MoviesDto
    suspend fun movie(id:String): MovieDto
}