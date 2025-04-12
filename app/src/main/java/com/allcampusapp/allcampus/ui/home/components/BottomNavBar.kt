package com.allcampusapp.allcampus.ui.home.components

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.allcampusapp.allcampus.MainActivity
import com.allcampusapp.allcampus.constants.Colors
import com.allcampusapp.allcampus.constants.K
import com.allcampusapp.allcampus.extension.toastShort
import com.google.firebase.auth.FirebaseAuth

@Composable
fun BottomNavBar() {
    val context = LocalContext.current // Get the current context

    val icons: Map<String, ImageVector> = mapOf(
        K.HOME to Icons.Default.Home,
        K.EXPLORE to Icons.Default.Search,
        K.PLAN to Icons.Outlined.Star,
        K.HISTORY to Icons.Default.DateRange,
        K.LOGOUT to Icons.AutoMirrored.Filled.ExitToApp
    )

    NavigationBar(containerColor = Colors.whiteBlack()) {
        listOf(K.HOME, K.EXPLORE, K.PLAN, K.HISTORY, K.LOGOUT).forEach { item ->
            NavigationBarItem(
                selected = item == K.HOME,
                onClick = {
                    if (item == K.LOGOUT) {
                        FirebaseAuth.getInstance().signOut()
                        context.startActivity(Intent(context, MainActivity::class.java))
                    } else context.toastShort("$item in progress")
                },
                icon = {
                    Icon(icons[item] ?: Icons.Default.Home, contentDescription = item)
                },
                label = { Text(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Colors.blackWhite(),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Colors.blackWhite(),
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFF03DAC5)
                )
            )
        }
    }
}
