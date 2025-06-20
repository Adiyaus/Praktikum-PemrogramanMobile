package com.example.modul5.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.modul5.viewmodel.SharedMovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(sharedViewModel: SharedMovieViewModel) {
    val selectedMovie = sharedViewModel.selectedMovie ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie Detail") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500${selectedMovie.posterPath}",
                    contentDescription = selectedMovie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "${selectedMovie.title} (${selectedMovie.year.substring(0, 4)})",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Overview",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = selectedMovie.plot,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}