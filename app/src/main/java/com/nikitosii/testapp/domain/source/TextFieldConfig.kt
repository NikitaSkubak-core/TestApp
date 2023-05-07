package com.nikitosii.testapp.domain.source

import androidx.lifecycle.MutableLiveData

data class TextFieldConfig(
    val attributeText: String,
    val attributeType: AttributeType,
    val errorText: String,
    val isValid: (String) -> Boolean,
    val value: MutableLiveData<String> = MutableLiveData("")
)