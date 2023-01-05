package com.example.c1_pokemoncards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.c1_pokemoncards.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.pokemontcg.io/"

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager

        getMyData()

    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(Api_Interface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<My_Data?> {
            override fun onResponse(call: Call<My_Data?>, response: Response<My_Data?>) {

                val responseBody = response.body()!!
                runOnUiThread({
//                    i have to bind the adapter to the recyclerView
                    binding.recyclerView.adapter  = MyAdaptor(baseContext, responseBody)

                })

            }

            override fun onFailure(call: Call<My_Data?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }

        })
    }
}