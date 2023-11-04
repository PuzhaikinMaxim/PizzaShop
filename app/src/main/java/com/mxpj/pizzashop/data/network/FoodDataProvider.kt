package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.domain.Food

interface FoodDataProvider {

    suspend fun getFoodList(): List<Food>
}