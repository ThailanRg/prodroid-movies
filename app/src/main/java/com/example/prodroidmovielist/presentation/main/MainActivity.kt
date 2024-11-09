package com.example.prodroidmovielist.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prodroidmovielist.core.routes.Routes
import com.example.prodroidmovielist.presentation.movie.navigateToMovie
import com.example.prodroidmovielist.presentation.movies.navigateToMovies
import com.example.prodroidmovielist.presentation.theme.ProdroidMovieListTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
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

    NavHost(
        navController = controller,
        startDestination = Routes.Movies
    ) {
        navigateToMovies {
            controller.navigate(it)
        }
        navigateToMovie {
            controller.popBackStack()
        }
    }
}