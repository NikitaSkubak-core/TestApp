package com.nikitosii.testapp.domain.source

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FieldsConfig(
    val configs: List<ConfigData> = listOf(ConfigData(), ConfigData(), ConfigData())
) : Parcelable