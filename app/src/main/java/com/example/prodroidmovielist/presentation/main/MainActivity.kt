package com.example.prodroidmovielist.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.presentation.movie.navigateToMovies
import com.example.prodroidmovielist.presentation.movies.navigateToMovie
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import com.example.prodroidmovielist.presentation.theme.black_1
import com.example.prodroidmovielist.presentation.theme.black_2
import com.example.prodroidmovielist.presentation.theme.black_3
import com.example.prodroidmovielist.presentation.theme.black_4
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            ProdroidMovieListTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val controller = rememberNavController()

    val brush = Brush.verticalGradient(listOf(black_1, black_2,black_3,black_4))

    Column(
        modifier = Modifier.fillMaxSize().background(brush = brush)
    ) {
        NavHost(
            navController = controller,
            startDestination = Routes.Movies
        ) {
            navigateToMovies {
                controller.navigate(Routes.Movie(it))
            }
            navigateToMovie()
        }
    }
}