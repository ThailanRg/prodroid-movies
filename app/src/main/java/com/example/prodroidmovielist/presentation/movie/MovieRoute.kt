package com.example.prodroidmovielist.presentation.movie

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.presentation.movies.MoviesIntent
import com.example.prodroidmovielist.presentation.movies.MoviesScreen
import com.example.prodroidmovielist.presentation.movies.MoviesViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.navigateToMovies(
    navigateTo: (String) -> Unit = {}
) {
    composable<Routes.Movies> {

        val viewModel = koinViewModel<MoviesViewModel>()

        LaunchedEffect(Unit) {
            viewModel.handleIntent(MoviesIntent.InitScreen)
        }

        val uiState = viewModel.uiState.collectAsState()

        MoviesScreen(
            uiState = uiState.value,
            onClick = { id ->
                viewModel.handleIntent(MoviesIntent.ChangeLoadingState(true))
                navigateTo(id)
            }
        )
    }
}