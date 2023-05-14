package com.nikitosii.testapp.ui.main

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nikitosii.testapp.R
import com.nikitosii.testapp.databinding.FragmentMainBinding
import com.nikitosii.testapp.domain.source.AttributeType
import com.nikitosii.testapp.ui.base.BaseFragment
import com.nikitosii.testapp.util.annotation.RequiresViewModel
import com.nikitosii.testapp.util.ext.isNotNull
import com.nikitosii.testapp.util.ext.onClick

@RequiresViewModel(MainViewModel::class)
class MainFragment : BaseFragment<MainViewModel>() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        subscribe()
    }

    private fun initViews() {
        with(binding) {
            tvTitle.text = getString(R.string.config_title, viewModel.counter.value?.plus(1) ?: 0)
            btnGo.onClick {
                val maxCount = viewModel.fieldsConfig.value?.configs?.size
                if (maxCount.isNotNull())
                    if ((viewModel.counter.value ?: 0) < maxCount!!)
                        updateList()
                    else openResult()
            }
        }
    }

    private fun subscribe() {
        with(viewModel) {
            isGotBack.observe(viewLifecycleOwner) {
                if (it) {
                    resetData()
                    isGotBack.value = false
                }
            }
        }
        viewModel.getListOfConfigs().forEach {
            val layout = TextInputLayout(requireContext())
            val et = TextInputEditText(requireContext())
            et.textSize = 15.0f
            val inputType = when (it.attributeType) {
                AttributeType.INT, AttributeType.BOOLEAN -> InputType.TYPE_CLASS_NUMBER
                AttributeType.DOUBLE -> InputType.TYPE_NUMBER_FLAG_DECIMAL
                else -> null
            }
            if (inputType.isNotNull())
                et.inputType = inputType!!
            layout.hint = it.attributeText
            et.doOnTextChanged { text, _, _, _ ->
                it.value = text.toString()
                layout.error = it.attributeType.errorMessage
                layout.isErrorEnabled = !it.isValid(text.toString())
                binding.btnGo.isEnabled = it.isValid(text.toString())
            }
            layout.addView(et)
            binding.llContainer.addView(layout)
        }
        binding.llContainer.children.forEach {
            val layout = it as TextInputLayout
            val params = layout.layoutParams
            params.height = 300
            layout.layoutParams = params
            val child = layout[0]
            val childParams = child.layoutParams
            childParams.height = 230
        }
    }


    private fun updateList() {
        binding.tvTitle.text = getString(R.string.config_title, viewModel.counter.value?.plus(1) ?: 0)
        binding.llContainer.removeAllViews()
        subscribe()
    }

    private fun openResult() {
        viewModel.fieldsConfig.value?.let { MainFragmentDirections.showResult(it).navigate() }
        viewModel.isGotBack.value = true
    }
}