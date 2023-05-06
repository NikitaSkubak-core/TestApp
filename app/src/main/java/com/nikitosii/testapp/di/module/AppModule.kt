package com.nikitosii.testapp.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nikitosii.testapp.di.util.TestApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {
    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideApp(application: Application): TestApp = application as TestApp

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

}