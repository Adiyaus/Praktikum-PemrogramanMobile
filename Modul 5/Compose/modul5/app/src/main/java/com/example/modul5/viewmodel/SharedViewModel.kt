package com.example.modul5.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.modul5.data.model.Movie

class SharedMovieViewModel : ViewModel() {
    var selectedMovie by mutableStateOf<Movie?>(null)
        private set

    fun selectMovie(movie: Movie) {
        selectedMovie = movie
    }
}