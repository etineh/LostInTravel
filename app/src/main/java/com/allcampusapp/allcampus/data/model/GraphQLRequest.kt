package com.allcampusapp.allcampus.data.model



data class Place(
    val _id: String? = null,
    val leadingDestinationTitle: String?,
    val subDestinationTitle: String?,
    val description: String? = null,
    val price: Float?,
    val iataCode: String? = null,
    val imageUrl: String? = null,
    val geoPoint: PlaceGeoPoint? = null
)

data class PlaceGeoPoint(
    val latitude: Float?,
    val longitude: Float?
)

data class PlaceDataResponse(val recommendedPlaces: List<Place>)
data class PlaceGraphQLResponse(val data: PlaceDataResponse)

data class GraphQLRequest(
    val query: String
)




