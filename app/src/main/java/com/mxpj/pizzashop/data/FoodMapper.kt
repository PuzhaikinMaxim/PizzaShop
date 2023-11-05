package com.mxpj.pizzashop.data

import com.mxpj.pizzashop.data.local.FoodDbModel
import com.mxpj.pizzashop.data.network.model.FoodResponse
import com.mxpj.pizzashop.domain.Food
import javax.inject.Inject

class FoodMapper @Inject constructor() {

    fun mapFoodResponseListToFoodList(list: List<FoodResponse>): List<Food> {
        return list.map { mapFoodResponseToFood(it) }
    }

    fun mapFoodResponseToFood(foodResponse: FoodResponse): Food {
        return Food(
            foodResponse.id,
            foodResponse.name,
            getFoodDescription(foodResponse),
            "от 320 р",
            foodResponse.image
        )
    }

    fun mapFoodDbModelListToFoodList(list: List<FoodDbModel>): List<Food> {
        return list.map { mapFoodDbModelToFood(it) }
    }

    fun mapFoodDbModelToFood(foodDbModel: FoodDbModel): Food {
        return Food(
            foodDbModel.id,
            foodDbModel.name,
            foodDbModel.description,
            foodDbModel.price,
            foodDbModel.imageLocation ?: "",
            true
        )
    }

    fun mapFoodListToFoodDbModelList(list: List<Food>): List<FoodDbModel> {
        return list.map { mapFoodToFoodDbModel(it) }
    }

    fun mapFoodToFoodDbModel(food: Food): FoodDbModel {
        return FoodDbModel(
            food.id,
            food.name,
            food.description,
            food.price,
            food.imageLocation
        )
    }

    private fun getFoodDescription(foodResponse: FoodResponse): String {
        return "${foodResponse.ingredient1}, ${foodResponse.ingredient2}, ${foodResponse.ingredient3}"
    }
}