package com.example.modul5.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modul5.data.model.Movie
import com.example.modul5.data.repository.MovieRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    val movies: StateFlow<List<Movie>> = repository.movies
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    val bookmarkedMovies: StateFlow<List<Movie>> = repository.bookmarkedMovies
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            repository.refreshMovies()
        }
    }

    fun toggleBookmark(movie: Movie) {
        viewModelScope.launch {
            val updatedMovie = movie.copy(isBookmarked = !movie.isBookmarked)
            repository.updateMovie(updatedMovie)
        }
    }
}