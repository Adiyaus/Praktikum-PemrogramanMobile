package com.example.modul4.viewmodel

import androidx.lifecycle.ViewModel
import com.example.modul4.data.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.modul4.model.Movie
import timber.log.Timber

class MovieViewModel(private val userId: String) : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> get() = _selectedMovie

    init {
        val movieList = MovieRepository.getMovies()
        _movies.value = movieList
        Timber.d("User $userId - Loaded movie list with ${movieList.size} items")
    }

    fun onMovieClick(movie: Movie) {
        _selectedMovie.value = movie
        Timber.d("User $userId - Movie clicked: ${movie.title}")
    }
}
