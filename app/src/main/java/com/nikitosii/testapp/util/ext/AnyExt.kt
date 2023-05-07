package com.nikitosii.testapp.util.ext

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
