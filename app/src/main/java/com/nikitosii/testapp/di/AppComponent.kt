package com.nikitosii.testapp.di

import android.app.Application
import com.nikitosii.testapp.di.module.ActivityModule
import com.nikitosii.testapp.di.module.AppModule
import com.nikitosii.testapp.di.module.FragmentModule
import com.nikitosii.testapp.di.module.ViewModelModule
import com.nikitosii.testapp.di.util.TestApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<TestApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(satisfyerApp: TestApp)
}