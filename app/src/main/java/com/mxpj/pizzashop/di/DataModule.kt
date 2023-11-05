package com.mxpj.pizzashop.di

import android.app.Application
import com.mxpj.pizzashop.data.FoodRepositoryImpl
import com.mxpj.pizzashop.data.ImageLoader
import com.mxpj.pizzashop.data.OfferRepositoryImpl
import com.mxpj.pizzashop.data.PicassoImageLoader
import com.mxpj.pizzashop.data.local.AppDatabase
import com.mxpj.pizzashop.data.local.FoodDao
import com.mxpj.pizzashop.data.network.*
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

    @Singleton
    @Binds
    fun offerDataProvider(impl: OfferDataProviderImpl): OfferDataProvider

    @Singleton
    @Binds
    fun imageLoader(impl: PicassoImageLoader): ImageLoader

    companion object {

        @Singleton
        @Provides
        fun provideFoodDao(
            application: Application
        ): FoodDao {
            return AppDatabase.getInstance(application).foodDao()
        }

        @Singleton
        @Provides
        fun provideFoodService(): FoodService {
            return FoodApiFactory.foodService
        }
    }
}