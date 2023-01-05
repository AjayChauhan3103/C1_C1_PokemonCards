package com.example.c1_pokemoncards

import retrofit2.Call
import retrofit2.http.GET

interface Api_Interface {

    @GET("v1/cards")

    fun getData(): Call<My_Data>
 
}