package com.example.modul5.data.remote

import com.example.modul5.data.model.MovieApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/tv")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("with_original_language") origin_language: String = "ko",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_watch_providers") providers: String = "8",
        @Query("watch_region") region: String = "ID",
    ): MovieApiResponse
}