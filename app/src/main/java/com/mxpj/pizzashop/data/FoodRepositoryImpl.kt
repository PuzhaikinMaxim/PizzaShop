package com.mxpj.pizzashop.data

import android.graphics.Bitmap
import com.mxpj.pizzashop.data.local.FoodDao
import com.mxpj.pizzashop.data.network.FoodDataProvider
import com.mxpj.pizzashop.domain.Food
import com.mxpj.pizzashop.domain.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDataProvider: FoodDataProvider,
    private val foodLocalDataProvider: FoodDao,
    private val foodMapper: FoodMapper,
    private val imageLoader: ImageLoader,
    private val imageWriter: ImageWriter
): FoodRepository {

    override suspend fun getFoodList(haveInternetConn: Boolean): List<Food> {
        return if(haveInternetConn){
            imageWriter.clearImages()
            foodLocalDataProvider.clearFoodList()
            val foodList = foodDataProvider.getFoodList()
            if(foodList == null) getFoodList(false)
            foodMapper.mapFoodResponseListToFoodList(foodList!!).sortedBy {
                it.id
            }
        } else{
            foodMapper.mapFoodDbModelListToFoodList(foodLocalDataProvider.getFoodList()).sortedBy {
                it.id
            }
        }
    }

    override suspend fun saveLocalFoodList(list: List<Food>) {
        val foodDbModelList = foodMapper.mapFoodListToFoodDbModelList(
            list.map {
                val imageBitmap: Bitmap?
                withContext(Dispatchers.Main) {
                    imageBitmap = imageLoader.loadImage(it.imageLocation)
                }
                val fileLocation: String? = imageWriter.writeImage(it.name, imageBitmap)
                it.copy(imageLocation = fileLocation ?: "")
            }
        )
        foodLocalDataProvider.addFoodList(foodDbModelList)
    }
}