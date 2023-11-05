package com.mxpj.pizzashop.domain

import androidx.lifecycle.LiveData

interface FoodRepository {

    suspend fun getFoodList(haveInternetConn: Boolean): List<Food>

    suspend fun saveLocalFoodList(list: List<Food>)
}