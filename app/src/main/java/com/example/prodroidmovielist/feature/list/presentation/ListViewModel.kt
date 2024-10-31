package com.example.prodroidmovielist.feature.list.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        viewModelScope.launch {
            useCase()
        }
    }

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
            }
        )
    }

    private fun updateState(state: ListUiState){
        uiState.update { state }
    }
}