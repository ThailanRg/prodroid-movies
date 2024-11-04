package com.example.prodroidmovielist.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prodroidmovielist.domain.MoviesUseCase
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
            is MoviesIntent.InitScreen -> initScreen()
            is MoviesIntent.ChangeLoadingState -> changeLoadingState(event.isLoading)
        }
    }

    private fun initScreen() {
        viewModelScope.launch {
            updateState(uiState.value.copy(movies = useCase(), isLoading = false))
        }
    }

    private fun changeLoadingState(isLoading:Boolean) {
        viewModelScope.launch {
            updateState(uiState.value.copy(isLoading = isLoading))
        }
    }

    private fun updateState(state: MoviesUiState) {
        uiState.update { state }
    }
}