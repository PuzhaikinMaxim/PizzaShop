package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.R
import com.mxpj.pizzashop.domain.Offer
import kotlinx.coroutines.delay
import javax.inject.Inject

class OfferDataProviderImpl @Inject constructor(): OfferDataProvider {

    override suspend fun getOfferList(): List<Offer> {
        delay(200)
        return listOf(
            Offer(1, R.drawable.offer_1),
            Offer(2, R.drawable.offer_2)
        )
    }
}