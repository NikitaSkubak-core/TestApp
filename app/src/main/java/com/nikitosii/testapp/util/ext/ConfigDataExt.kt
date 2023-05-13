package com.nikitosii.testapp.util.ext

import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.FieldsConfig
import com.nikitosii.testapp.util.AttributeConstants

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

fun ConfigData.getColorHex(
    colorRed: String,
    colorGreen: String,
    colorBlue: String,
    isNeedToCheck: Boolean = false,
    defaultInt: Int = -1
): String {
    val colorRed = findIntOrElse(colorRed, defaultInt)
    val colorGreen = findIntOrElse(colorGreen, defaultInt)
    val colorBlue = findIntOrElse(colorBlue, defaultInt)
    return if (isNeedToCheck) when (defaultInt) {
        colorRed, colorGreen, colorBlue -> ""
        else -> RGBToHex(colorRed, colorGreen, colorBlue)
    } else RGBToHex(colorRed, colorGreen, colorBlue)
}

fun checkConfig(data: FieldsConfig, filter: String, count: Int): Boolean =
    data.configs.filter { it.findValue(filter).isNotEmpty() }.size == count