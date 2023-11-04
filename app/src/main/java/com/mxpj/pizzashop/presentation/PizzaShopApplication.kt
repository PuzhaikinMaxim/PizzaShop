package com.mxpj.pizzashop.presentation

import android.app.Application
import com.mxpj.pizzashop.di.DaggerApplicationComponent

class PizzaShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}