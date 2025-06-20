package com.example.modul4.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.modul4.R
import com.example.modul4.viewmodel.SharedMovieViewModel

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
                .padding(16.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = selectedMovie.posterResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(550.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = String.format(
                        stringResource(R.string.movie_detail_title),
                        selectedMovie.title,
                        selectedMovie.year
                    ),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Text(
                    text = "${stringResource(R.string.plot_label)}:\n${selectedMovie.plot}"
                )
            }
        }
    }
}
