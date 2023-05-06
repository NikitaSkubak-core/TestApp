package com.nikitosii.testapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nikitosii.testapp.util.annotation.AnnotationUtil
import com.nikitosii.testapp.util.ext.findParentNavController
import com.nikitosii.testapp.util.ext.isNotNull
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber

class BaseActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
    @IdRes navControllerId: Int?
) : DaggerAppCompatActivity() {

    lateinit var binding: T

    val navController by lazy {
        if (navControllerId != null) findParentNavController(navControllerId) else null
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        inject()
        super.onCreate(savedInstanceState, persistentState)
        initContentView()
        initNavController()
    }

    private fun inject() {
        if (AnnotationUtil.hasInject(this)) {
            AndroidInjection.inject(this)
        }
    }

    private fun initContentView() {
        binding = DataBindingUtil.inflate(this.layoutInflater, layoutRes, null, false)
        setContentView(binding.root)
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
}