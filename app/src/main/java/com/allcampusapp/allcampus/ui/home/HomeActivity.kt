package com.allcampusapp.allcampus.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.allcampusapp.allcampus.ui.home.components.HomeScreen
import com.allcampusapp.allcampus.ui.theme.TravelLabTheme

val LocalDarkMode = compositionLocalOf { mutableStateOf(false) }

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelLabTheme(darkTheme = LocalDarkMode.current.value) {
                HomeScreen()
            }
        }
    }
}


