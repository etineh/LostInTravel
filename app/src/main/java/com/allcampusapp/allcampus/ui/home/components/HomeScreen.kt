package com.allcampusapp.allcampus.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.allcampusapp.allcampus.viewModels.HomeViewModel
import com.allcampusapp.allcampus.viewModels.PlaceViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    placeViewModel: PlaceViewModel = viewModel(),
) {
    // Trigger fetch once when this composable is first composed
    LaunchedEffect(Unit) {
        placeViewModel.fetchRecommendedPlaces()
    }

    // Collect the list from the StateFlow
    val places by placeViewModel.places.collectAsState()
    println("the place is $places")

    Scaffold(
        bottomBar = { BottomNavBar() },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            HeaderSection("Samira")
            Spacer(Modifier.height(16.dp))
            SearchBar()
            Spacer(Modifier.height(24.dp))
            FrequentlyVisited(viewModel.frequentPlaceModels)
            Spacer(Modifier.height(24.dp))
            RecommendedPlaces(places ?: viewModel.recommendedPlaceModels)
        }
    }
}
