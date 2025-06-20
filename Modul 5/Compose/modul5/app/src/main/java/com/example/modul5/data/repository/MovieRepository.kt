package com.example.modul5.data.repository

import com.example.modul5.BuildConfig
import com.example.modul5.data.local.MovieDao
import com.example.modul5.data.model.Movie
import com.example.modul5.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class MovieRepository(
    private val apiService: ApiService,
    private val movieDao: MovieDao
) {
    val movies = movieDao.getAllMovies()
    val bookmarkedMovies = movieDao.getBookmarkedMovies()

    suspend fun updateMovie(movie: Movie) {
        movieDao.updateMovie(movie)
    }

    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            try {
                val oldMovies = movieDao.getAllMovies().first()
                val bookmarkedIds = oldMovies.filter { it.isBookmarked }.map { it.id }.toSet()

                val newMoviesFromApi = apiService.getPopularMovies(BuildConfig.TMDB_API_KEY).results

                val newMovies = newMoviesFromApi.map { apiMovie ->
                    apiMovie.copy(isBookmarked = bookmarkedIds.contains(apiMovie.id))
                }

                movieDao.insertAll(newMovies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}