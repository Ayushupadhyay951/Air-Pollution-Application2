package com.example.airpollutionapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.airpollutionapplication.Network.AirPollutionResponse
import com.example.airpollutionapplication.Network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class WeatherState(
    val result: AirPollutionResponse = AirPollutionResponse(),
    val status: Status = Status.LOADING,
    val error: String = "",
)

class AirViewModel() : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            try {
                val result = WeatherApi.retrofitService.getWeather(
                    lat = 26.50,
                    lon = 80.80,
                    apiKey = "a7cd198c020bb86e19ee90789e199908"
                )
                _state.update { it.copy(result = result, status = Status.SUCCESS) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message?:"Something went wrong")
                }
            }
        }
    }
}