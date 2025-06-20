package com.example.m3xml.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m3xml.data.DataSource
import com.example.m3xml.data.Film

class FilmViewModel : ViewModel() {
    private val _films = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>> = _films

    init {
        _films.value = DataSource.getFilms()
    }

    fun getFilmById(id: Int): Film? {
        return _films.value?.find { it.id == id }
    }
}