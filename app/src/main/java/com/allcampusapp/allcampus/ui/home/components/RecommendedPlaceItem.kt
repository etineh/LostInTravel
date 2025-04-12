package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.allcampusapp.allcampus.constants.Colors
import com.allcampusapp.allcampus.data.model.Place
import com.allcampusapp.allcampus.data.model.PlaceGeoPoint
import com.allcampusapp.allcampus.data.model.PlaceModel

@Composable
fun RecommendedPlaceItem(place: Place) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Colors.cardBackground())
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(), // Ensure Row takes up the full width
            horizontalArrangement = Arrangement.SpaceBetween // Push the second column to the end
        ) {
            Image(
                painter = rememberAsyncImagePainter(place.imageUrl),
                contentDescription = place.imageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(place.leadingDestinationTitle!!, color = Colors.blackWhite(), fontWeight = FontWeight.SemiBold)
                Text(place.subDestinationTitle!!, color = Colors.blackWhite(), fontSize = 13.sp)
            }
            Column(
                verticalArrangement = Arrangement.Center, // Center content vertically
                horizontalAlignment = Alignment.End // Align to the end horizontally
            ) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "FAVORITE")
                Text("${place.price}/person", color = Colors.beechColor(), fontSize = 14.sp)
            }
        }
    }

}
