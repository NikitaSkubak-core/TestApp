package com.nikitosii.testapp.ui.main

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.Config
import com.nikitosii.testapp.domain.source.FieldsConfig
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val fieldsConfig = FieldsConfig()
    val counter = MutableLiveData(0)
    private val textViewList = mutableListOf<EditText>()

    fun addViewToList(et: EditText) {
        textViewList.add(et)
    }

    fun getListOfConfigs(): List<Config> {
        val list = fieldsConfig.configs[counter.value ?: 0].data
        counter.value = counter.value?.plus(1)
        return list
    }
}

