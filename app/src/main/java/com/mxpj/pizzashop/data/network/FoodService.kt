package com.mxpj.pizzashop.data.network

import com.google.gson.JsonObject
import com.mxpj.pizzashop.data.network.model.FoodListResponse
import com.mxpj.pizzashop.data.network.model.FoodResponse
import retrofit2.Response
import retrofit2.http.GET

interface FoodService {
    @GET("randomselection.php")
    suspend fun getFoodList(): Response<String>

    @GET("random.php")
    suspend fun getFood(): Response<FoodListResponse>
}