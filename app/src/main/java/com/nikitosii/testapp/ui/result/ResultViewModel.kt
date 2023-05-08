package com.nikitosii.testapp.ui.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitosii.testapp.domain.source.FieldsConfig
import javax.inject.Inject

class ResultViewModel @Inject constructor(): ViewModel() {
    val fieldsConfig = MutableLiveData<FieldsConfig>()
}