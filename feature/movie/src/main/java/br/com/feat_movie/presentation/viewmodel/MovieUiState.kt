package br.com.feat_movie.presentation.viewmodel

import br.com.feat_movie.data.model.MovieDto

data class MovieUiState(
    val movie: MovieDto = MovieDto(),
    val isLoading: Boolean = true
)