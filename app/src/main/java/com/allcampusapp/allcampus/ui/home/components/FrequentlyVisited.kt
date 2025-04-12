package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.allcampusapp.allcampus.constants.Colors
import com.allcampusapp.allcampus.data.model.PlaceModel

@Composable
fun FrequentlyVisited(placeModels: List<PlaceModel>) {
    Column {
        Text("Frequently Visited", color = Colors.blackWhite())

        Spacer(Modifier.height(8.dp))
        LazyRow {
            items(placeModels) {
                PlaceCard(it)
            }
        }
    }
}