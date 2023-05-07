package com.nikitosii.testapp.ui.main

import android.text.InputType.TYPE_CLASS_NUMBER
import android.text.InputType.TYPE_TEXT_VARIATION_NORMAL
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.nikitosii.testapp.databinding.ItemTextFieldConfigBinding
import com.nikitosii.testapp.domain.source.AttributeType
import com.nikitosii.testapp.domain.source.TextFieldConfig

class TextFieldConfigViewHolder(private val binding: ItemTextFieldConfigBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: TextFieldConfig) {
        with(binding) {
            etFieldConfig.inputType = when (data.attributeType) {
                AttributeType.INT, AttributeType.DOUBLE, AttributeType.BOOLEAN -> TYPE_CLASS_NUMBER
                else -> TYPE_TEXT_VARIATION_NORMAL
            }
            tilConfiField.hint = data.attributeText
            etFieldConfig.setOnFocusChangeListener { _, hasFocus ->
                val text = etFieldConfig.text.toString()
                data.value.value = text
                if (!hasFocus && !data.isValid(text)) {
                    tilConfiField.error = data.errorText
                    tilConfiField.isErrorEnabled = true
                }
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): TextFieldConfigViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemTextFieldConfigBinding.inflate(layoutInflater, parent, false)
            return TextFieldConfigViewHolder(binding)
        }
    }
}