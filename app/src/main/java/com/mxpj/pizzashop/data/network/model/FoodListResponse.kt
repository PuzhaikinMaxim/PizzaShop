package com.mxpj.pizzashop.data.network.model

import com.google.gson.annotations.SerializedName

data class FoodListResponse(
    @SerializedName("meals")
    val foodList: List<FoodResponse>
)