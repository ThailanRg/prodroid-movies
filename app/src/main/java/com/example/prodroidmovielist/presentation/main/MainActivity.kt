package com.example.prodroidmovielist.presentation.main

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.bundle.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.core_navigation.Routes
import br.com.feat_movie.presentation.navigateToMovie
import br.com.feat_movies.presentation.navigateToMovies

class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            br.com.core_design_system.ProdroidMovieListTheme {
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