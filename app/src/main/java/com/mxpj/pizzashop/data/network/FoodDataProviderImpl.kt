package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.domain.Food
import javax.inject.Inject

class FoodDataProviderImpl @Inject constructor(
    private val foodService: FoodService
): FoodDataProvider {

    override suspend fun getFoodList(): List<Food> {
        try {
            println(foodService.getFoodList())
        } catch (ex: Exception){
            ex.printStackTrace()
        }
        return listOf()
    }
}