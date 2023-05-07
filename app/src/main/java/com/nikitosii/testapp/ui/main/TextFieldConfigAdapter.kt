package com.nikitosii.testapp.ui.main

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nikitosii.testapp.domain.source.Config

class TextFieldConfigAdapter :
    ListAdapter<Config, TextFieldConfigViewHolder>(TextFieldConfigCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextFieldConfigViewHolder {
       return TextFieldConfigViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TextFieldConfigViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TextFieldConfigCallback : DiffUtil.ItemCallback<Config>() {
        override fun areItemsTheSame(oldItem: Config, newItem: Config): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Config, newItem: Config): Boolean {
            return oldItem.attributeText == newItem.attributeText
        }
    }
}