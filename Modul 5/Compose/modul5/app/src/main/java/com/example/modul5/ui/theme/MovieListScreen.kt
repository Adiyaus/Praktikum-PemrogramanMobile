package com.example.modul5.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.modul5.viewmodel.MovieViewModel
import com.example.modul5.viewmodel.SharedMovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    sharedViewModel: SharedMovieViewModel
) {
    val movieList by movieViewModel.movies.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("KDrama Cinema") })
        }
    ) { paddingValues ->
        if (movieList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(movieList) { movie ->
                    MovieListItem(
                        movie = movie,
                        movieViewModel = movieViewModel,
                        sharedViewModel = sharedViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}