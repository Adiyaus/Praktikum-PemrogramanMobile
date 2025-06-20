package com.example.scrollablelist_modul3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scrollablelist_modul3.data.MovieRepository
import com.example.scrollablelist_modul3.navigation.Screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(navController: NavController) {
    val movieList = MovieRepository.getMovies()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "KDrama Cinema")
                }
            )
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
                        // Poster Film
                        Image(
                            painter = painterResource(id = movie.posterResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 100.dp, height = 150.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        // Detail Film
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
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.imdb))
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier.padding(end = 8.dp)
                                ) {
                                    Text(text = "IMDB")
                                }

                                Button(
                                    onClick = {
                                        navController.navigate(
                                            Screen.Detail.createRoute(
                                                movie.title,
                                                movie.year,
                                                movie.plot,
                                                movie.posterResId
                                            )
                                        )
                                    }
                                ) {
                                    Text(text = "Detail")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
