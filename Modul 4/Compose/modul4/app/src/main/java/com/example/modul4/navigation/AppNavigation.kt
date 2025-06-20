package com.example.modul4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modul4.ui.screens.DetailScreen
import com.example.modul4.ui.screens.MovieListScreen
import com.example.modul4.viewmodel.SharedMovieViewModel
import com.example.modul4.viewmodel.MovieViewModel

@Composable
fun AppNavigation(
    sharedViewModel: SharedMovieViewModel,
    movieViewModel: MovieViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MovieList.route) {
        composable(Screen.MovieList.route) {
            MovieListScreen(
                navController = navController,
                sharedViewModel = sharedViewModel,
                movieViewModel = movieViewModel
            )
        }
        composable(Screen.Detail.route) {
            DetailScreen(sharedViewModel = sharedViewModel)
        }
    }
}
