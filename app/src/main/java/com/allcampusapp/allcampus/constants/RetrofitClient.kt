package com.allcampusapp.allcampus.constants

import com.allcampusapp.allcampus.services.api.GraphQLApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://lostapi.frontendlabs.co.uk/"

    val apiService: GraphQLApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GraphQLApiService::class.java)
    }
}
