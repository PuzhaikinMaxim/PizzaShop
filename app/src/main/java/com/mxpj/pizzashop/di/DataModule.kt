package com.mxpj.pizzashop.di

import com.mxpj.pizzashop.data.FoodRepositoryImpl
import com.mxpj.pizzashop.data.OfferRepositoryImpl
import com.mxpj.pizzashop.data.network.FoodApiFactory
import com.mxpj.pizzashop.data.network.FoodDataProvider
import com.mxpj.pizzashop.data.network.FoodDataProviderImpl
import com.mxpj.pizzashop.data.network.FoodService
import com.mxpj.pizzashop.domain.FoodRepository
import com.mxpj.pizzashop.domain.OfferRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    @Singleton
    @Binds
    fun foodRepository(impl: FoodRepositoryImpl): FoodRepository

    @Singleton
    @Binds
    fun offerRepository(impl: OfferRepositoryImpl): OfferRepository

    @Singleton
    @Binds
    fun foodDataProvider(impl: FoodDataProviderImpl): FoodDataProvider

    companion object {

        @Singleton
        @Provides
        fun provideFoodService(): FoodService {
            return FoodApiFactory.foodService
        }
    }
}