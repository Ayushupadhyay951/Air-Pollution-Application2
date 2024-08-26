package com.example.airpollutionapplication.Screens

data class AirPollutionResponse(
    val coord: Coordinates,
    val list: List<AirPollution>
)

data class Coordinates(
    val lon: Double,
    val lat: Double
)

data class AirPollution(
    val main: Main,
    val components: Components
)

data class Main(
    val aqi: Int // Air Quality Index
)

data class Components(
    val co: Double, // Carbon monoxide
    val no: Double, // Nitrogen monoxide
    val no2: Double, // Nitrogen dioxide
    val o3: Double, // Ozone
    val so2: Double, // Sulfur dioxide
    val pm2_5: Double, // Particulate matter < 2.5 micrometers
    val pm10: Double, // Particulate matter < 10 micrometers
    val nh3: Double // Ammonia
)

