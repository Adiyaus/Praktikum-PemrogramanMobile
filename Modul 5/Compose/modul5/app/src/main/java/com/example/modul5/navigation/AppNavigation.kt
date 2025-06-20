package com.example.modul5.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modul5.ui.theme.DetailScreen
import com.example.modul5.ui.theme.MovieListScreen
import com.example.modul5.viewmodel.MovieViewModel
import com.example.modul5.viewmodel.SharedMovieViewModel

@Composable
fun AppNavigation(
    movieViewModel: MovieViewModel,
    sharedViewModel: SharedMovieViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MovieList.route) {
        composable(Screen.MovieList.route) {
            MovieListScreen(
                navController = navController,
                movieViewModel = movieViewModel,
                sharedViewModel = sharedViewModel
            )
        }
        composable(Screen.Detail.route) {
            DetailScreen(sharedViewModel = sharedViewModel)
        }
    }
}