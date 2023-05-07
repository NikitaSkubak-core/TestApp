package com.nikitosii.testapp.util.ext

import android.view.View

inline fun View.onClick(crossinline onClick: () -> Unit) {
    this.setOnClickListener { onClick.invoke() }
}