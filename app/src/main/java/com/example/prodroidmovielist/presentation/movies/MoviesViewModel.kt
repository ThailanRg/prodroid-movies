package com.example.prodroidmovielist.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.domain.MoviesUseCase
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEffect.GoToDetail
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.InitScreen
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.Loading
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.SendEffect
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val useCase: MoviesUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(MoviesUiState())
    val uiState: StateFlow<MoviesUiState> = _uiState

    private var _effect = Channel<GoToDetail>()
    val effect = _effect.receiveAsFlow()

    fun handleIntent(event: MoviesEvent) {
        when (event) {
            InitScreen -> initScreen()
            is Loading -> loadingChange(event.isLoading)
            is SendEffect -> sendEffect(event.routes)
        }
    }

    private fun initScreen() {
        viewModelScope.launch {
            updateState(_uiState.value.copy(movies = useCase()))
        }
    }

    private fun loadingChange(event:Boolean) {
        viewModelScope.launch {
            updateState(_uiState.value.copy(isLoading = event))
        }
    }

    private fun sendEffect(value: Routes) {
        viewModelScope.launch {
            _effect.send(GoToDetail(value))
        }
    }

    private fun updateState(state: MoviesUiState) {
        _uiState.update { state }
    }
}