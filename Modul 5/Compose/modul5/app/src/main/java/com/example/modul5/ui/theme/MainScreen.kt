package com.example.modul5.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.modul5.navigation.Screen
import com.example.modul5.viewmodel.MovieViewModel
import com.example.modul5.viewmodel.SharedMovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(movieViewModel: MovieViewModel, sharedViewModel: SharedMovieViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                // Item untuk Home
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = currentDestination?.hierarchy?.any { it.route == Screen.MovieList.route } == true,
                    onClick = {
                        navController.navigate(Screen.MovieList.route) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                // Item untuk Bookmark
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Bookmark, contentDescription = "Bookmark") },
                    label = { Text("Bookmarks") },
                    selected = currentDestination?.hierarchy?.any { it.route == "bookmark_screen" } == true,
                    onClick = {
                        navController.navigate("bookmark_screen") {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.MovieList.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.MovieList.route) {
                MovieListScreen(
                    navController = navController,
                    movieViewModel = movieViewModel,
                    sharedViewModel = sharedViewModel
                )
            }
            composable("bookmark_screen") {
                BookmarkScreen(
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
}