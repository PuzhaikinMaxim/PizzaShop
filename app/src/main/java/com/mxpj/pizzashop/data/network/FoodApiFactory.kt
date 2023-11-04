package com.mxpj.pizzashop.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FoodApiFactory {

    private const val URL = "https://www.themealdb.com/api/json/v1/1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL)
        .build()

    val foodService = retrofit.create(FoodService::class.java)
}