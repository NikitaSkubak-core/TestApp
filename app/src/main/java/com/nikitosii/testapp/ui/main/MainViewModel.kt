package com.nikitosii.testapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitosii.testapp.domain.source.Config
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.FieldsConfig
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val fieldsConfig = MutableLiveData(FieldsConfig())
    val counter = MutableLiveData(0)
    val isGotBack = MutableLiveData(false)

    fun getListOfConfigs(): List<Config> {
        val list = fieldsConfig.value?.configs?.get(counter.value ?: 0)?.data ?: listOf()
        counter.value = counter.value?.plus(1)
        return list
    }

    fun resetData() {
        counter.value = 0
        fieldsConfig.value = FieldsConfig()
    }
}

