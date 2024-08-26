package com.example.airpollutionapplication.Network

import com.example.airpollutionapplication.Screens.AirPollutionResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface ApiServices {
    @GET("coord")
    suspend fun getWeather(
        @Query("q") lat: Double,
        @Query("r") lon: Double,
        @Query("appid") apiKey: String,
    ): com.example.airpollutionapplication.Network.AirPollutionResponse
}
object WeatherApi {
    val retrofitService: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}