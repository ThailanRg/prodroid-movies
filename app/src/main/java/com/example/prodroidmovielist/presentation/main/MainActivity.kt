package com.example.prodroidmovielist.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.prodroidmovielist.feature.list.presentation.ListScreen
import com.example.prodroidmovielist.feature.list.presentation.ListViewModel
import com.example.prodroidmovielist.feature.list.presentation.OnEvenListScreen
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = koinViewModel<ListViewModel>()

            LaunchedEffect(Unit) {
                viewModel.onEvent(OnEvenListScreen.InitScreen)
            }

            val uiState = viewModel.uiState.collectAsState()

            ProdroidMovieListTheme {
                ListScreen(uiState = uiState.value)
            }

        }
    }
}