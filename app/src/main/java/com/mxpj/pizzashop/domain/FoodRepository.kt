package com.mxpj.pizzashop.domain

import androidx.lifecycle.LiveData

interface FoodRepository {

    suspend fun getFoodList(): List<Food>
}