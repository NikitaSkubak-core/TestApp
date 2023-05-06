package com.nikitosii.testapp.util.annotation

import androidx.lifecycle.ViewModel

object AnnotationUtil {
    fun findViewModelClass(any: Any): Class<out ViewModel> {
        return any.javaClass.getAnnotation(RequiresViewModel::class.java)!!.value.java
    }

    fun hasInject(any: Any) = any.javaClass.isAnnotationPresent(RequiresInject::class.java)

    fun hasViewModel(any: Any) = any.javaClass.isAnnotationPresent(RequiresViewModel::class.java)

}