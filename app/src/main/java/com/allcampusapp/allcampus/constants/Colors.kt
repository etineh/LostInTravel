package com.allcampusapp.allcampus.constants

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Colors {
    @Composable
    fun blackWhite() = MaterialTheme.colorScheme.onBackground


    @Composable
    fun searchBackground() = MaterialTheme.colorScheme.surfaceVariant

    @Composable
    fun cardBackground(): Color =
        if (K.isDarkMode()) Color(0xFF303030) else Color(0xFFF8F7F7)

    @Composable
    fun beechColor(): Color =
        if (K.isDarkMode()) Color(0xFF03DAC5) else Color(0xFF056158)

    @Composable
    fun whiteBlack(): Color =
        if (K.isDarkMode()) Color.Black else Color.White

}