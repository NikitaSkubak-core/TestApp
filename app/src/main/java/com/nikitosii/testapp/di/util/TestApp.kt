package com.nikitosii.testapp.di.util

import android.content.Context
import com.nikitosii.testapp.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class TestApp : DaggerApplication(), HasAndroidInjector {


    private val appInjector: AppComponent =  com.nikitosii.testapp.di.DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        appInjector

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        INSTANCE = this
        appInjector.inject(this)
    }

    companion object {
        private var INSTANCE: TestApp? = null

        @JvmStatic
        fun get(): TestApp = INSTANCE!!

        @JvmStatic
        fun getAppComponent(): AppComponent {
            return get().appInjector
        }
    }
}