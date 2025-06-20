package com.example.modul5.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val title: String,

    @SerialName("first_air_date")
    val year: String,

    @SerialName("overview")
    val plot: String,

    @SerialName("poster_path")
    val posterPath: String?,

    val isBookmarked: Boolean = false,
)

@Serializable
data class MovieApiResponse(
    val results: List<Movie>
)