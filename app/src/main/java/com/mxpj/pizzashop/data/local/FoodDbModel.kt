package com.mxpj.pizzashop.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
class FoodDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val imageLocation: String?,
)