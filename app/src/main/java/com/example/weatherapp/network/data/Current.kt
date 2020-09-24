package com.example.weatherapp.network.data

data class Current(
    val temp_c: Double?,
    val condition: Condition,
    val wind_kph: Double?,
)