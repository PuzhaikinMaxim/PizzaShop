package com.mxpj.pizzashop.domain

interface OfferRepository {

    suspend fun getOfferList(): List<Offer>
}