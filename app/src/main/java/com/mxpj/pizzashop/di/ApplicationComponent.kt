package com.mxpj.pizzashop.di

import android.app.Application
import com.mxpj.pizzashop.presentation.MenuFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: MenuFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}