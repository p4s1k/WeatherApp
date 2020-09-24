package com.example.weatherapp.repository

import com.example.weatherapp.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRepository {
    private lateinit var service: RetrofitService

    fun getService(): RetrofitService{
        if (!::service.isInitialized){
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            service= retrofit.create(RetrofitService::class.java)
        }
        return service
    }
}