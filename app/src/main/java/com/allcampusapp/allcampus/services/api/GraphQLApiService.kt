package com.allcampusapp.allcampus.services.api

import com.allcampusapp.allcampus.data.model.GraphQLRequest
import com.allcampusapp.allcampus.data.model.PlaceGraphQLResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface GraphQLApiService {
    @POST("graphql")
    suspend fun getRecommendedPlaces(@Body request: GraphQLRequest): PlaceGraphQLResponse
}

