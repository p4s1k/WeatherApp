package com.example.weatherapp.network.data

data class GsonData(
    val location: Location,
    val current: Current,
    val forecast: Forecast,
    val day: Day
)