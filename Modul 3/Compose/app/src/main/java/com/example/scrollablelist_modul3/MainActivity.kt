package com.example.scrollablelist_modul3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scrollablelist_modul3.navigation.AppNavigation
import com.example.scrollablelist_modul3.ui.theme.ScrollableListModul3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListModul3Theme {
                AppNavigation()
            }
        }
    }
}
