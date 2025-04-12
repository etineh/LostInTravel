package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.allcampusapp.allcampus.R
import com.allcampusapp.allcampus.constants.Colors
import androidx.compose.ui.unit.dp
import com.allcampusapp.allcampus.extension.toastShort
import com.allcampusapp.allcampus.ui.home.LocalDarkMode

@Composable
fun HeaderSection(name: String) {

    val systemDarkMode = isSystemInDarkTheme()
//    var isDarkMode by remember { mutableStateOf(systemDarkMode) }
    val context = LocalContext.current
    val isDarkMode = LocalDarkMode.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text("Welcome $name,", color = Colors.blackWhite(), fontSize = 20.sp)
            Text("Where do you want to go?", color = Color.Gray, fontSize = 14.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                context.toastShort("in progress")
            }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Colors.blackWhite()
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            IconButton(onClick = {isDarkMode.value = !isDarkMode.value }) {
                Icon(
                    painter = painterResource(id = if (isDarkMode.value) R.drawable.baseline_toggle_on_24
                    else R.drawable.baseline_toggle_off_24),
                    contentDescription = "Icon description",
                    modifier = Modifier.size( 36.dp),
                    tint = Colors.beechColor()
                )
            }
        }
    }
}
