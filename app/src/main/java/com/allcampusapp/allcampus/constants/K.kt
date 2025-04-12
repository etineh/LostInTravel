package com.allcampusapp.allcampus.constants

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.allcampusapp.allcampus.ui.home.LocalDarkMode

object K {
    @Composable
    fun isDarkMode(): Boolean = LocalDarkMode.current.value

    const val HOME = "Home"
    const val EXPLORE = "Explore"
    const val PLAN = "Plan"
    const val HISTORY = "History"
    const val LOGOUT = "Logout"

}
