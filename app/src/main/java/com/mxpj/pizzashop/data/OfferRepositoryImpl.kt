package com.mxpj.pizzashop.data

import com.mxpj.pizzashop.data.network.OfferDataProvider
import com.mxpj.pizzashop.domain.Offer
import com.mxpj.pizzashop.domain.OfferRepository
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(
    private val offerDataProvider: OfferDataProvider
): OfferRepository {

    override suspend fun getOfferList(): List<Offer> {
        return offerDataProvider.getOfferList()
    }
}