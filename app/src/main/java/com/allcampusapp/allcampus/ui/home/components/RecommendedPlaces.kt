package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.allcampusapp.allcampus.constants.Colors
import com.allcampusapp.allcampus.data.model.Place
import com.allcampusapp.allcampus.data.model.PlaceModel

@Composable
fun RecommendedPlaces(placeModels: List<Place>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Recommended Places", color = Colors.blackWhite())

        Text("Explore All", color = Colors.beechColor())
    }
    Spacer(Modifier.height(17.dp))
    Column {
        placeModels.forEach {
            RecommendedPlaceItem(it)
            Spacer(Modifier.height(12.dp))
        }
    }
}