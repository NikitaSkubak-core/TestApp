package com.nikitosii.testapp.domain.source

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Config(
    val attributeText: String,
    val attributeType: AttributeType,
    val errorText: String,
    val isValid: (String) -> Boolean,
    var value: String = ""
): Parcelable