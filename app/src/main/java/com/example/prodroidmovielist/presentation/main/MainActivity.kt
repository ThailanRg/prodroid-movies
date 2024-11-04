package com.example.prodroidmovielist.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.presentation.movie.navigateToMovies
import com.example.prodroidmovielist.presentation.movies.navigateToMovie
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme
import com.example.prodroidmovielist.presentation.theme.black_1
import com.example.prodroidmovielist.presentation.theme.black_2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//        enableEdgeToEdge()
        setContent {
            ProdroidMovieListTheme {
                App()
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun App() {
    val controller = rememberNavController()

    val brush = Brush.verticalGradient(listOf(black_1, black_1, black_1, black_2).reversed())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
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