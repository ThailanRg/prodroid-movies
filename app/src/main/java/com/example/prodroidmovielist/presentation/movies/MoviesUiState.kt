package com.example.prodroidmovielist.presentation.movies

import com.example.prodroidmovielist.data.model.movies.MoviesDto

data class MoviesUiState(
    val movies: MoviesDto = MoviesDto(page = 0)
)