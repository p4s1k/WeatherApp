package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.RetrofitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RetrofitRepository) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val dataLiveData = MutableLiveData<MutableMap<String,String>>()

    private var mapList = mutableMapOf<String,String>()

    fun getForecast(city:String) {
        coroutineScope.launch {
            try {
                val gson = repository.getService().getForecast(city)
                mapList["temp"] = gson.current.temp_c.toString()+"°"
                mapList["text"] = gson.current.condition.text.toString()
                var a= gson.current.wind_kph
                if (a != null) a= a*1000/60/60
                mapList["wind"]= a.toString()
                mapList["forecast"] = gson.location.region.toString()
                mapList["icon"] = gson.current.condition.icon.toString()
                dataLiveData.postValue(mapList)
            } catch (e: Exception) {
                e.message
            }
        }
    }

}