package com.example.prodroidmovielist.presentation.movie

import com.example.prodroidmovielist.data.model.movie.MovieDto

data class MovieUiState(
    val movie: MovieDto = MovieDto(),
    val isLoading: Boolean = true
)