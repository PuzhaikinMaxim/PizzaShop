package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.data.network.model.FoodResponse
import com.mxpj.pizzashop.domain.Food
import javax.inject.Inject

class FoodDataProviderImpl @Inject constructor(
    private val foodService: FoodService
): FoodDataProvider {

    override suspend fun getFoodList(): List<FoodResponse>? {
        try {
            val foodList = mutableListOf<FoodResponse>()
            repeat(10){ foodList.add(foodService.getFood().body()!!.foodList[0]) }
            return foodList
        } catch (ex: Exception){
            ex.printStackTrace()
        }
        return null
    }
}