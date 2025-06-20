package com.example.m3xml.viewmodel

import androidx.lifecycle.ViewModel
import com.example.m3xml.data.DataSource
import com.example.m3xml.data.Film
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber

class FilmViewModel(private val someString: String) : ViewModel() {
    private val _filmList = MutableStateFlow<List<Film>>(emptyList())
    val filmList: StateFlow<List<Film>> = _filmList

    private val _navigateToDetail = MutableStateFlow<Film?>(null)
    val navigateToDetail: StateFlow<Film?> = _navigateToDetail.asStateFlow()

    init {
        Timber.i("FilmViewModel created with string: $someString")
        loadFilms()
    }

    private fun loadFilms() {
        _filmList.value = DataSource.getFilms()
        Timber.i("Data film berhasil dimuat. Jumlah data: ${_filmList.value.size}")
    }
    fun getFilmById(id: Int): Film? {
        return _filmList.value.find { it.id == id }
    }

    fun onFilmClicked(film: Film) {
        _navigateToDetail.update { film }
    }

    fun onNavigateToDetailComplete() {
        _navigateToDetail.update { null }
    }
}