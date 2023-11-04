package com.mxpj.pizzashop.data

import com.mxpj.pizzashop.data.network.FoodDataProvider
import com.mxpj.pizzashop.domain.Food
import com.mxpj.pizzashop.domain.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDataProvider: FoodDataProvider
): FoodRepository {

    override suspend fun getFoodList(): List<Food> {
        return foodDataProvider.getFoodList()
    }
}