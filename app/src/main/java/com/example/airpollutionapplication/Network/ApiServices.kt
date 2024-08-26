package com.example.airpollutionapplication.Network

import com.example.airpollutionapplication.Screens.AirPollutionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("data/2.5/air_pollution")
    suspend fun getAirPollution(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String
    ): AirPollutionResponse
}
