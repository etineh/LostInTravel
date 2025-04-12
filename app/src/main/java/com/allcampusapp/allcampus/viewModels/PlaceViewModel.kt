package com.allcampusapp.allcampus.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allcampusapp.allcampus.constants.RetrofitClient
import com.allcampusapp.allcampus.data.model.GraphQLRequest
import com.allcampusapp.allcampus.data.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlaceViewModel : ViewModel() {

    private val query = """
    query {
        RecommendedPlaces {
            _id
            leadingDestinationTitle
            subDestinationTitle
            description
            price
            iataCode
            imageUrl
            geoPoint {
                latitude
                longitude
            }
        }
    }
""".trimIndent()



    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places

    fun fetchRecommendedPlaces() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRecommendedPlaces(
                    GraphQLRequest(query)
                )
                _places.value = response.data.recommendedPlaces
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
