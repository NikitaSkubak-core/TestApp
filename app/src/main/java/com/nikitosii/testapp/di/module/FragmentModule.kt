package com.nikitosii.testapp.di.module

import com.nikitosii.testapp.ui.main.MainFragment
import com.nikitosii.testapp.ui.result.ResultFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    fun contributeResultFragment(): ResultFragment
}