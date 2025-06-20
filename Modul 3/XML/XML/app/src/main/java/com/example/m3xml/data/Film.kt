package com.example.m3xml.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val id: Int,
    val title: String,
    val year: String,
    val plot: String,
    val poster: Int,
    val imdbUrl: String
) : Parcelable