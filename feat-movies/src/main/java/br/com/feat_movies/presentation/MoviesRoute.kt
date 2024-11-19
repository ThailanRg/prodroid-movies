package br.com.feat_movies.presentation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.core_navigation.Routes
import br.com.feat_movies.presentation.screen.MoviesScreen
import br.com.feat_movies.presentation.viewmodel.MoviesIntent.MoviesEvent.InitScreen
import br.com.feat_movies.presentation.viewmodel.MoviesViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.navigateToMovies(
    navigateTo: (br.com.core_navigation.Routes) -> Unit = {}
) {
    composable<br.com.core_navigation.Routes.Movies> {

        val viewModel = koinViewModel<MoviesViewModel>()
        val uiState = viewModel.uiState.collectAsState()
        val effect = viewModel.effect

        LaunchedEffect(Unit) {
            viewModel.handleIntent(InitScreen)
            effect.collect { route ->
                route.routes?.let { route -> navigateTo(route) }
            }
        }
        br.com.core_design_system.ProdroidMovieListTheme {
            MoviesScreen(
                uiState = uiState.value,
                onEvent = { event ->
                    viewModel.handleIntent(event)
                }
            )
        }
    }
}