package com.example.modul5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.modul5.data.local.AppDatabase
import com.example.modul5.data.remote.RetrofitClient
import com.example.modul5.data.repository.MovieRepository
import com.example.modul5.ui.theme.MainScreen
import com.example.modul5.ui.theme.Modul5Theme
import com.example.modul5.viewmodel.MovieViewModel
import com.example.modul5.viewmodel.MovieViewModelFactory
import com.example.modul5.viewmodel.SharedMovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)
        val apiService = RetrofitClient.instance
        val repository = MovieRepository(apiService, database.movieDao())
        val factory = MovieViewModelFactory(repository)

        val movieViewModel: MovieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val sharedViewModel: SharedMovieViewModel = ViewModelProvider(this)[SharedMovieViewModel::class.java]

        setContent {
            Modul5Theme {
                MainScreen(
                    movieViewModel = movieViewModel,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}