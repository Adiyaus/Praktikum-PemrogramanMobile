package com.example.modul4.navigation

import android.net.Uri

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object Detail : Screen("movie_detail/{title}/{year}/{plot}/{posterResId}") {
        fun createRoute(title: String, year: String, plot: String, posterResId: Int): String {
            return "movie_detail/${Uri.encode(title)}/${Uri.encode(year)}/${Uri.encode(plot)}/$posterResId"
        }
    }
}