package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.repository.RetrofitRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitRepository)
        )
            .get(MainViewModel::class.java)

        viewModel.dataLiveData.observe(this, observer)

        button_forecast.setOnClickListener {
            viewModel.getForecast(edit_text.text.toString())
        }

    }

    private val observer = Observer<MutableMap<String,String>> {
        text_c.text=it["temp"]
        text_text.text=it["text"]
        text_max.text=it["wind"]
        text_forecast.text=it["forecast"]

        Picasso
            .get()
            .load("http:${it["icon"]}")
            .into(image_weather)
    }
}