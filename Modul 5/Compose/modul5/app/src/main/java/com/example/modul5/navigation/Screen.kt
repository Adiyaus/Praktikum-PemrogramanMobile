package com.example.modul5.navigation

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object Detail : Screen("movie_detail")
}