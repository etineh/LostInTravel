package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.allcampusapp.allcampus.data.model.PlaceModel
import coil.compose.rememberAsyncImagePainter
import com.allcampusapp.allcampus.constants.Colors

@Composable
fun PlaceCard(placeModel: PlaceModel) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(width = 160.dp, height = 200.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Colors.cardBackground())
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(placeModel.imageUrl),
                contentDescription = placeModel.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Column(Modifier.padding(horizontal = 8.dp)) {
                Text(placeModel.name, color = Colors.blackWhite(), fontWeight = FontWeight.Bold)
                Text(placeModel.location, color = Colors.blackWhite(), fontSize = 12.sp)
                Text(placeModel.price,
                    color = Colors.beechColor(),
                    fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }
        }
    }
}
