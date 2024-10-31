package com.example.prodroidmovielist.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prodroidmovielist.presentation.movie.MovieIntent
import com.example.prodroidmovielist.presentation.movie.MovieScreen
import com.example.prodroidmovielist.presentation.movie.MovieViewModel
import com.example.prodroidmovielist.presentation.movies.MoviesScreen
import com.example.prodroidmovielist.presentation.movies.MoviesViewModel
import com.example.prodroidmovielist.presentation.movies.MoviesIntent
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            ProdroidMovieListTheme {

                val controller = rememberNavController()

                NavHost(navController = controller, startDestination = "movies") {
                    composable("movies") {

                        val viewModel = koinViewModel<MoviesViewModel>()

                        LaunchedEffect(Unit) {
                            viewModel.handleIntent(MoviesIntent.LoadingMovies)
                        }

                        val uiState = viewModel.uiState.collectAsState()

                        MoviesScreen(uiState = uiState.value, onClick = {
                            Log.d("TAG", "onCreate: ${it}")
                            controller.navigate("details/$it")
                        })
                    }
                    composable("details/{id}") { navBackStackEntry ->
                        val uId = navBackStackEntry.arguments?.getString( "id" ).orEmpty()

                        val viewModel = koinViewModel<MovieViewModel>()

                        LaunchedEffect(Unit) {
                            viewModel.handleIntent(MovieIntent.LoadingMovie(uId))
                        }

                        val uiState = viewModel.uiState.collectAsState()

                        MovieScreen(uiState = uiState.value, uId = uId )
                    }
                }
            }
        }
    }
}