package com.example.prodroidmovielist.presentation.movies

sealed interface MoviesIntent {
    data object LoadingMovies : MoviesIntent
}