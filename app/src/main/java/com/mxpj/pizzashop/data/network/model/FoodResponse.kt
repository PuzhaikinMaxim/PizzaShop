package com.mxpj.pizzashop.data.network.model

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("idMeal")
    val id: Int,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strIngredient1")
    val ingredient1: String,
    @SerializedName("strIngredient2")
    val ingredient2: String,
    @SerializedName("strIngredient3")
    val ingredient3: String,
    @SerializedName("strMealThumb")
    val image: String
) {
}