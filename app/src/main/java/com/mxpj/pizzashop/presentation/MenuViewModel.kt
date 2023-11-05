package com.mxpj.pizzashop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mxpj.pizzashop.R
import com.mxpj.pizzashop.domain.Food
import com.mxpj.pizzashop.domain.FoodRepository
import com.mxpj.pizzashop.domain.Offer
import com.mxpj.pizzashop.domain.OfferRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
    private val offerRepository: OfferRepository
): ViewModel() {

    private val _foodList = MutableLiveData<List<Food>>()
    val foodList: LiveData<List<Food>>
        get() = _foodList

    val _offerList = MutableLiveData<List<Offer>>()
    val offerList: LiveData<List<Offer>>
        get() = _offerList

    fun setLists(hasNetworkConn: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val foodList = foodRepository.getFoodList(hasNetworkConn)
            _foodList.postValue(foodList)
            _offerList.postValue(offerRepository.getOfferList())
            withContext(Dispatchers.Default){
                foodRepository.saveLocalFoodList(foodList)
            }
        }
    }
}