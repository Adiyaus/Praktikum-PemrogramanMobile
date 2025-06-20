package com.example.modul4.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.modul4.navigation.Screen
import com.example.modul4.viewmodel.MovieViewModel
import com.example.modul4.viewmodel.SharedMovieViewModel
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    sharedViewModel: SharedMovieViewModel
) {
    val context = LocalContext.current
    val movieList by movieViewModel.movies.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("KDrama Cinema") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp)
        ) {
            items(movieList) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(id = movie.posterResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 100.dp, height = 150.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = movie.title,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = movie.year,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = movie.plot,
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 3
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(
                                    onClick = {
                                        Timber.d("Tombol Explicit Intent (IMDB) ditekan untuk film: ${movie.title}")
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.imdb))
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier.padding(end = 8.dp)
                                ) {
                                    Text("IMDB")
                                }

                                Button(
                                    onClick = {
                                        Timber.d("Tombol Detail ditekan.")
                                        Timber.i("Data yang dipilih untuk detail: Judul=${movie.title}")

                                        movieViewModel.onMovieClick(movie)
                                        sharedViewModel.selectMovie(movie)
                                        navController.navigate(Screen.Detail.route)
                                    }
                                ) {
                                    Text("Detail")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
