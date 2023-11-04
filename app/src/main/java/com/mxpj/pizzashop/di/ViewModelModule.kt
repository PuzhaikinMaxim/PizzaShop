package com.mxpj.pizzashop.di

import androidx.lifecycle.ViewModel
import com.mxpj.pizzashop.presentation.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindMenuViewModel(menuViewModel: MenuViewModel): ViewModel
}