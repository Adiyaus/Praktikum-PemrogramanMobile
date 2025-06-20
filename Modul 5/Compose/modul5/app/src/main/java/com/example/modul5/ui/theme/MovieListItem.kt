package com.example.modul5.ui.theme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.modul5.data.model.Movie
import com.example.modul5.navigation.Screen
import com.example.modul5.viewmodel.MovieViewModel
import com.example.modul5.viewmodel.SharedMovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListItem(
    movie: Movie,
    movieViewModel: MovieViewModel,
    sharedViewModel: SharedMovieViewModel,
    navController: NavController
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                contentDescription = movie.title,
                modifier = Modifier
                    .size(width = 100.dp, height = 150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(onClick = { movieViewModel.toggleBookmark(movie) }) {
                        Icon(
                            imageVector = if (movie.isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                // Tahun Rilis
                Text(
                    text = movie.year?.substring(0, 4) ?: "N/A",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Plot
                Text(
                    text = movie.plot ?: "No overview available.",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick = {
                        val query = Uri.encode(movie.title)
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/find?q=$query"))
                        context.startActivity(intent)
                    }, modifier = Modifier.padding(end = 8.dp)) {
                        Text("IMDB")
                    }

                    Button(onClick = {
                        sharedViewModel.selectMovie(movie)
                        navController.navigate(Screen.Detail.route)
                    }) {
                        Text("Detail")
                    }
                }
            }
        }
    }
}