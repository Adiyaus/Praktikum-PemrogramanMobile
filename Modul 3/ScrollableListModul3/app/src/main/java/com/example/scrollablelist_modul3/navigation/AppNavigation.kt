package com.example.scrollablelist_modul3.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scrollablelist_modul3.ui.DetailScreen
import com.example.scrollablelist_modul3.ui.MovieListScreen
import com.example.scrollablelist_modul3.R


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MovieList.route) {
        composable(Screen.MovieList.route) {
            MovieListScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("year") { type = NavType.StringType },
                navArgument("plot") { type = NavType.StringType },
                navArgument("posterResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val year = backStackEntry.arguments?.getString("year") ?: ""
            val plot = backStackEntry.arguments?.getString("plot") ?: ""
            val posterResId = backStackEntry.arguments?.getInt("posterResId") ?: R.drawable.ngaran

            DetailScreen(
                title = title,
                year = year,
                plot = plot,
                posterResId = posterResId)
        }
    }
}