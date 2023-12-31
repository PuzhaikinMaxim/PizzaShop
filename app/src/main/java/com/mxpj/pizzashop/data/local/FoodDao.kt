package com.mxpj.pizzashop.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {

    @Query("SELECT * FROM food")
    fun getFoodList(): List<FoodDbModel>

    @Query("DELETE FROM food")
    fun clearFoodList()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFoodList(list: List<FoodDbModel>)
}