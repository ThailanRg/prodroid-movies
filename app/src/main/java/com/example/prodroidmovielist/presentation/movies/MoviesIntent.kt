package com.example.prodroidmovielist.presentation.movies

sealed interface MoviesIntent {
    data object InitScreen : MoviesIntent
    data class ChangeLoadingState(val isLoading:Boolean = false) : MoviesIntent
}