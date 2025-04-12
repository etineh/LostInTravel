package com.allcampusapp.allcampus.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var isLoading = mutableStateOf(false)
        private set

    fun setLoading(value: Boolean) {
        isLoading.value = value
    }
}
