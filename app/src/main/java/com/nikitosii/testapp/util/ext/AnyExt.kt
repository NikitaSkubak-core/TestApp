package com.nikitosii.testapp.util.ext

import android.content.res.ColorStateList
import android.graphics.Color

fun Any?.isNotNull(): Boolean = this != null

fun String.isIntValid(validation: (Int) -> Boolean): Boolean {
    return if (this.isEmpty()) true
    else {
        try {
            val number = this.toInt()
            val result = validation(number)
            return result
        }
        catch (e: NumberFormatException) {
            false
        }
    }
}

fun String.isDoubleValid(validation: (Double) -> Boolean): Boolean {
    return if (this.isEmpty()) true
    else {
        try {
            val number = this.toDouble()
            validation(number)
        }
        catch (e: NumberFormatException) {
            false
        }
    }
}

fun Int.ifNegative(value: Int): Int {
    return if (this >= 0) this else value
}

fun maxInt(value1: Int, value2: Int): Int {
    return if (value1 >= value2) value1 else value2
}

fun getColorState(colorHex: String): ColorStateList {
    return ColorStateList.valueOf(Color.parseColor(colorHex))
}
