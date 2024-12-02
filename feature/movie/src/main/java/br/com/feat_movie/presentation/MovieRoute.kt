package br.com.feat_movie.presentation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.core_navigation.Routes
import br.com.feat_movie.presentation.screen.MovieScreen
import br.com.feat_movie.presentation.viewmodel.MovieIntent
import br.com.feat_movie.presentation.viewmodel.MovieViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.navigateToMovie(
    navigateTo: () -> Unit = {}
) {
    composable<Routes.Movie> { arguments ->

        val args = arguments.toRoute<Routes.Movie>()

        val viewModel = koinViewModel<MovieViewModel>()

        LaunchedEffect(Unit) {
            viewModel.handleIntent(MovieIntent.LoadingMovie(args.id))
        }

        val uiState = viewModel.uiState.collectAsState()

        MovieScreen(uiState = uiState.value){
            navigateTo()
        }

    }
}
