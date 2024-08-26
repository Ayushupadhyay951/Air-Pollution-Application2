package com.example.airpollutionapplication.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AirPollutionViewModel : ViewModel() {
    private val apiService = NetworkModule.apiService

    var airPollutionData: AirPollutionResponse? = null
        private set

    fun fetchAirPollutionData(latitude: Double, longitude: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                airPollutionData = apiService.getAirPollution(latitude, longitude, apiKey)
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
