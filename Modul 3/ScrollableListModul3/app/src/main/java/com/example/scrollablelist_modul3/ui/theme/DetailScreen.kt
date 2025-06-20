package com.example.scrollablelist_modul3.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.scrollablelist_modul3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(title: String, year: String, plot: String, posterResId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movie Detail")
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = posterResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = String.format(stringResource(R.string.movie_detail_title), title, year),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${stringResource(R.string.plot_label)}:\n$plot")
        }
    }
}