package com.nikitosii.testapp.ui.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.nikitosii.testapp.di.ViewModelProviderFactory
import com.nikitosii.testapp.util.annotation.AnnotationUtil
import com.nikitosii.testapp.util.ext.safeNavigation
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment<VM : ViewModel>() :
    DaggerFragment() {
    protected val navController by lazy { findNavController() }

    @field:Inject
    lateinit var vmFactory: ViewModelProviderFactory

    protected open lateinit var viewModel: VM

    fun NavDirections.navigate() {
        navController.safeNavigation(this)
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    private fun inject() {
        if (AnnotationUtil.hasViewModel(this)) {
            AndroidSupportInjection.inject(this)
            initViewModel()
        } else if (AnnotationUtil.hasInject(this)) {
            AndroidSupportInjection.inject(this)
        }
    }

    private fun initViewModel() {
        val vmClass: Class<out ViewModel> = AnnotationUtil.findViewModelClass(this)
        viewModel = ViewModelProviders.of(this, vmFactory).get(vmClass) as VM
    }
}