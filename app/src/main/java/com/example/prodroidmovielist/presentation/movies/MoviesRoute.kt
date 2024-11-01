package com.example.prodroidmovielist.presentation.movies

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.presentation.movie.MovieIntent
import com.example.prodroidmovielist.presentation.movie.MovieScreen
import com.example.prodroidmovielist.presentation.movie.MovieViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.navigateToMovie(
    navigateTo: (String) -> Unit = {}
) {
    composable<Routes.Movie> { arguments ->

        val args = arguments.toRoute<Routes.Movie>()

        val viewModel = koinViewModel<MovieViewModel>()

        LaunchedEffect(Unit) {
            viewModel.handleIntent(MovieIntent.LoadingMovie(args.id))
        }

        val uiState = viewModel.uiState.collectAsState()

        MovieScreen(uiState = uiState.value)

    }
}