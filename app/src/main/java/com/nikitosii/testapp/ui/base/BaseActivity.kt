package com.nikitosii.testapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import com.nikitosii.testapp.databinding.ActivityMainBinding
import com.nikitosii.testapp.util.annotation.AnnotationUtil
import com.nikitosii.testapp.util.ext.findParentNavController
import com.nikitosii.testapp.util.ext.isNotNull
import com.nikitosii.testapp.util.ext.safeNavigation
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

open class BaseActivity(
    @LayoutRes val layoutInt: Int,
    @IdRes navControllerId: Int?
) : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val navController by lazy {
        if (navControllerId != null) findParentNavController(navControllerId) else null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(layoutInt)
        AndroidInjection.inject(this)
        initNavController()
    }

    private fun initNavController() {
        if (navController.isNotNull()) {
            val callback = onBackPressedDispatcher.addCallback(this) {
                Timber.d("onBackPressedDispatcher")
                if (navController?.navigateUp() == false) {
                    isEnabled = false
                    onBackPressed()
                }
            }
            navController?.addOnDestinationChangedListener { controller, destination, arguments ->
                callback.isEnabled = true
            }
        }
    }

    private fun inject() {
        if (AnnotationUtil.hasInject(this))
            AndroidInjection.inject(this)
    }

    override fun onSupportNavigateUp() = navController?.navigateUp() ?: super.onSupportNavigateUp()

    fun NavDirections.navigate() {
        navController?.safeNavigation(this)
    }
}