package com.example.modul4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.modul4.ui.theme.Modul4Theme
import com.example.modul4.navigation.AppNavigation
import com.example.modul4.viewmodel.SharedMovieViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul4.viewmodel.MovieViewModel
import com.example.modul4.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MovieViewModelFactory("Initial Data")
        val movieViewModel: MovieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        val sharedViewModel: SharedMovieViewModel = ViewModelProvider(this)[SharedMovieViewModel::class.java]

        setContent {
            Modul4Theme {
                AppNavigation(
                    sharedViewModel = sharedViewModel,
                    movieViewModel = movieViewModel
                )
            }
        }
    }
}
