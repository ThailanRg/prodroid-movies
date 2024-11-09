package com.example.prodroidmovielist.presentation.movies

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.core.routes.Routes.Movies
import com.example.prodroidmovielist.presentation.movies.MoviesIntent.MoviesEvent.InitScreen
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.navigateToMovies(
    navigateTo: (Routes) -> Unit = {}
) {
    composable<Movies> {

        val viewModel = koinViewModel<MoviesViewModel>()
        val uiState = viewModel.uiState.collectAsState()
        val effect = viewModel.effect

        LaunchedEffect(Unit) {
            viewModel.handleIntent(InitScreen)
            effect.collect { route ->
                route.routes?.let { route -> navigateTo(route) }
            }
        }
        ProdroidMovieListTheme {
            MoviesScreen(
                uiState = uiState.value,
                onEvent = { event ->
                    viewModel.handleIntent(event)
                }
            )
        }
    }
}