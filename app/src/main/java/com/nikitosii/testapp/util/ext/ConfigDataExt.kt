package com.nikitosii.testapp.util.ext

import android.content.res.ColorStateList
import android.graphics.Color
import com.nikitosii.testapp.domain.source.ConfigData

fun ConfigData.findIntOrElse(filter: String, value: Int): Int {
    return data.first { it.attributeText == filter }.value.toIntOrElse(value)
}

fun ConfigData.findDoubleOrElse(filter: String, value: Double): Double {
    return data.first { it.attributeText == filter }.value.toDoubleOrElse(value)
}

fun ConfigData.findFloatOrElse(filter: String, value: Float): Float {
    return data.first { it.attributeText == filter }.value.toFloatOrElse(value)
}

fun ConfigData.findValue(filter: String): String {
    return data.first { it.attributeText == filter }.value
}

fun ConfigData.findBoolean(filter: String): Boolean {
    val value = data.first { it.attributeText == filter }.value.toIntOrElse(0)
    return value == 1
}

fun ConfigData.getColorInt(
    colorRed: String,
    colorGreen: String,
    colorBlue: String,
    alpha: String = "1",
    isNeedToCheck: Boolean = false,
    defaultInt: Int = 0
): Int {
    val colorRed = findIntOrElse(colorRed, defaultInt)
    val colorGreen = findIntOrElse(colorGreen, defaultInt)
    val colorBlue = findIntOrElse(colorBlue, defaultInt)
    val alpha = (alpha.toFloatOrElse(1.0f) * 255 / 100).toInt()
    return if (isNeedToCheck) when (defaultInt) {
        colorRed, colorGreen, colorBlue -> -1
        else -> Color.argb(alpha, colorRed, colorGreen, colorBlue)
    } else Color.argb(alpha, colorRed, colorGreen, colorBlue)
}

fun ConfigData.getColorHex(
    colorRed: String,
    colorGreen: String,
    colorBlue: String,
    isNeedToCheck: Boolean = false,
    defaultInt: Int = 0
): String {
    val colorRed = findIntOrElse(colorRed, defaultInt)
    val colorGreen = findIntOrElse(colorGreen, defaultInt)
    val colorBlue = findIntOrElse(colorBlue, defaultInt)
    return if (isNeedToCheck) when (defaultInt) {
        colorRed, colorGreen, colorBlue -> ""
        else -> RGBToHex(colorRed, colorGreen, colorBlue)
    } else RGBToHex(colorRed, colorGreen, colorBlue)
}