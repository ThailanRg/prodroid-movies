package com.example.prodroidmovielist.presentation.movie

sealed interface MovieIntent {
     data class LoadingMovie(val id:String) : MovieIntent
}