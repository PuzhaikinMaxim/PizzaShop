package com.mxpj.pizzashop.data

import com.mxpj.pizzashop.domain.Offer
import com.mxpj.pizzashop.domain.OfferRepository
import javax.inject.Inject

class OfferRepositoryImpl @Inject constructor(

): OfferRepository {

    override suspend fun getOfferList(): List<Offer> {
        TODO("Not yet implemented")
    }
}