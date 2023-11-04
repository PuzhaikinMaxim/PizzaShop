package com.mxpj.pizzashop.data.network

import retrofit2.Response
import retrofit2.http.GET

interface FoodService {
    @GET("randomselection.php")
    suspend fun getFoodList(): Response<String>
}