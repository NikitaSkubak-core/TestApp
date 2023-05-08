package com.nikitosii.testapp.util.ext

fun String.toIntOrElse(value: Int): Int {
    return try{
        this.toInt()
    }
    catch (e: NumberFormatException) {
        value
    }
}

fun String.toDoubleOrElse(value: Double): Double {
    return try{
        this.toDouble()
    }
    catch (e: NumberFormatException) {
        value
    }
}

fun String.toFloatOrElse(value: Float): Float {
    return try{
        this.toFloat()
    }
    catch (e: NumberFormatException) {
        value
    }
}

fun RGBToHex(red : Int, green : Int, blue : Int): String {
    return String.format("#%02x%02x%02x", red, green, blue)
}

