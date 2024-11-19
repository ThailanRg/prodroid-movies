package br.com.feat_movie.presentation.viewmodel

sealed interface MovieIntent {
     data class LoadingMovie(val id:String) : MovieIntent
}