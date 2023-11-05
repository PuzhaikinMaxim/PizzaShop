package com.mxpj.pizzashop.data.network

import com.mxpj.pizzashop.domain.Offer

interface OfferDataProvider {

    suspend fun getOfferList(): List<Offer>
}