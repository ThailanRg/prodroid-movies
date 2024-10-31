package com.example.prodroidmovielist.presentation.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prodroidmovielist.domain.MovieUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(
    private val useCase: MovieUseCase
) : ViewModel() {

    var uiState = MutableStateFlow(MovieUiState())
        private set

    fun handleIntent(event: MovieIntent) {
        when (event) {
            is MovieIntent.LoadingMovie -> initScreen(event.id)
        }
    }

    private fun initScreen(id:String) {
        viewModelScope.launch(
            context = CoroutineExceptionHandler { _, _ ->
                Log.d("TAG", "initScreen: ")
            },
            block = {
                updateState(uiState.value.copy(movie = useCase(id)))
            }
        )
    }

    private fun updateState(state: MovieUiState) {
        uiState.update { state }
    }
}