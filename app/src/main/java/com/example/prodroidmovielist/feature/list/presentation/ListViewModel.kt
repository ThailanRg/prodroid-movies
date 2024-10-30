package com.example.prodroidmovielist.feature.list.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prodroidmovielist.feature.list.data.model.MovieDto
import com.example.prodroidmovielist.feature.list.domain.ListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(
private val useCase: ListUseCase
) : ViewModel() {

    var uiState = MutableStateFlow(ListUiState())
        private set

    fun onEvent( event: OnEvenListScreen){
        when(event){
            is OnEvenListScreen.InitScreen -> initScreen()
        }
    }

    private fun initScreen() {
        viewModelScope.launch(
            context = CoroutineExceptionHandler { _, _ ->
                Log.d("TAG", "initScreen: ")
            },

            block = {
                Log.d("TAG", "initScreen: ")
                updateState(uiState.value.copy(list = listOf(
                    MovieDto(id = 1, title = "lanterna verde"),
                    MovieDto(id = 0, title = "marvel")
                )))
            }
        )
    }

    private fun updateState(state: ListUiState){
        uiState.update { state }
    }
}