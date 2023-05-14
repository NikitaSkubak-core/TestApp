package com.nikitosii.testapp.ui.main

import android.text.InputType.TYPE_CLASS_NUMBER
import android.text.InputType.TYPE_TEXT_VARIATION_NORMAL
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikitosii.testapp.databinding.ItemTextFieldConfigBinding
import com.nikitosii.testapp.domain.source.AttributeType
import com.nikitosii.testapp.domain.source.Config

class TextFieldConfigViewHolder(private val binding: ItemTextFieldConfigBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Config) {
        with(binding) {
            etFieldConfig.inputType = when (data.attributeType) {
                AttributeType.INT, AttributeType.DOUBLE, AttributeType.BOOLEAN -> TYPE_CLASS_NUMBER
                else -> TYPE_TEXT_VARIATION_NORMAL
            }
            tilConfiField.hint = data.attributeText
            etFieldConfig.setOnFocusChangeListener { _, hasFocus ->
                val text = etFieldConfig.text.toString()
                data.value = text
                if (!hasFocus) {
                    tilConfiField.error = data.attributeType.errorMessage
                    tilConfiField.isErrorEnabled = !data.isValid(text)
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