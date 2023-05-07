package com.nikitosii.testapp.ui.main

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.TextFieldConfig
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val configDataList = mutableListOf(ConfigData(), ConfigData(), ConfigData())
    val counter = MutableLiveData(0)
    private val textViewList = mutableListOf<EditText>()

    fun addViewToList(et: EditText) {
        textViewList.add(et)
    }

    fun getListOfConfigs(): List<TextFieldConfig> {
        val list = configDataList[counter.value ?: 0].data
        counter.value = counter.value?.plus(1)
        return list
    }
}

