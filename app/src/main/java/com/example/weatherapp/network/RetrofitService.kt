package com.example.weatherapp.network

import com.example.weatherapp.network.data.GsonData
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("forecast.json?lang=ru&key=747cd86675c442dfb0e140144202309")
    suspend fun getForecast(
        @Query("q") city: String
    ): GsonData
}