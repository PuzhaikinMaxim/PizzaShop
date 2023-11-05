package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.data.network.model.FoodResponse

interface FoodDataProvider {

    suspend fun getFoodList(): List<FoodResponse>?
}