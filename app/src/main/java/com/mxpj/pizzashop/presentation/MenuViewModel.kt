package com.mxpj.pizzashop.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mxpj.pizzashop.R
import com.mxpj.pizzashop.domain.Food
import com.mxpj.pizzashop.domain.FoodRepository
import com.mxpj.pizzashop.domain.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val foodRepository: FoodRepository
): ViewModel() {

    val foodList = listOf(
        Food(1,"Pizza1","desc1","от 200 р",2),
        Food(2,"Pizza2","desc2","от 200 р",2),
        Food(3,"Pizza3","desc3","от 200 р",2),
        Food(4,"Pizza4","desc4","от 200 р",2),
        Food(5,"Pizza5","desc5","от 200 р",2),
        Food(6,"Pizza6","desc6","от 200 р",2),
    )

    val offerList = listOf(
        Offer(1, R.drawable.offer_1),
        Offer(2, R.drawable.offer_2),
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getFoodList()
        }
    }
}