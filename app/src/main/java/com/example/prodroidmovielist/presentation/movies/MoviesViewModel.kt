package com.example.prodroidmovielist.presentation.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prodroidmovielist.domain.MoviesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val useCase: MoviesUseCase
) : ViewModel() {

    var uiState = MutableStateFlow(MoviesUiState())
        private set

    fun handleIntent(event: MoviesIntent) {
        when (event) {
            is MoviesIntent.LoadingMovies -> initScreen()
        }
    }

    private fun initScreen() {
        viewModelScope.launch(
            context = CoroutineExceptionHandler { _, _ ->
                Log.d("TAG", "initScreen: ")
            },
            block = {
                updateState(uiState.value.copy(movies = useCase(), isLoading = false))
            }
        )
    }

    private fun updateState(state: MoviesUiState) {
        uiState.update { state }
    }
}