package com.nikitosii.testapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nikitosii.testapp.di.ViewModelKey
import com.nikitosii.testapp.di.ViewModelProviderFactory
import com.nikitosii.testapp.ui.main.MainViewModel
import com.nikitosii.testapp.ui.result.ResultViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    fun bindMResultViewModel(viewModel: ResultViewModel): ViewModel
}