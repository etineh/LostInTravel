package com.allcampusapp.allcampus.viewModels

import androidx.lifecycle.ViewModel
import com.allcampusapp.allcampus.data.model.Place
import com.allcampusapp.allcampus.data.model.PlaceModel

class HomeViewModel : ViewModel() {
    val frequentPlaceModels = listOf(
        PlaceModel(
            "Mykonos", "Chora, Greece", "$1800/person",
            "https://images.unsplash.com/photo-1507525428034-b723cf961d3e" // Beach
        ),
        PlaceModel(
            "Venice", "Venice, Italy", "$1800/person",
            "https://images.unsplash.com/photo-1507525428034-b723cf961d3e" // Beach
        ),
        PlaceModel("Mykonos", "Chora, Greece", "$1800/person", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        PlaceModel("Waterfort", "Venice, Italy", "$1800/person", "https://via.placeholder.com/150")
    )

    val recommendedPlaceModels = listOf(
        Place(leadingDestinationTitle = "Sumbing Mount", subDestinationTitle =  "Chora, Greece", price =  1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        Place(leadingDestinationTitle ="Maldives", subDestinationTitle = "Maldives", price = 1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        Place(leadingDestinationTitle ="Kigali Resort", subDestinationTitle = "Kigali, Rwanda", price = 1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        Place(leadingDestinationTitle = "Sumbing Mount", subDestinationTitle =  "Chora, Greece", price =  1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        Place(leadingDestinationTitle ="Maldives", subDestinationTitle = "Maldives", price = 1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
        Place(leadingDestinationTitle ="Kigali Resort", subDestinationTitle = "Kigali, Rwanda", price = 1350F, imageUrl = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"),
    )
}