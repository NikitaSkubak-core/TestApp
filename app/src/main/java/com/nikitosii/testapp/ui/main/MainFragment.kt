package com.nikitosii.testapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikitosii.testapp.databinding.FragmentMainBinding
import com.nikitosii.testapp.ui.base.BaseFragment
import com.nikitosii.testapp.util.annotation.RequiresViewModel
import com.nikitosii.testapp.util.ext.onClick

@RequiresViewModel(MainViewModel::class)
class MainFragment : BaseFragment<MainViewModel>() {
    private lateinit var binding: FragmentMainBinding
    private val adapter by lazy { TextFieldConfigAdapter() }
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
            rvConfig.adapter = adapter
            rvConfig.adapter = adapter
            rvConfig.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            btnGo.onClick {
                if ((viewModel.counter.value ?: 0) < 3)
                    updateAdapterList()
                else openResult()
            }
        }
    }

    private fun subscribe() {
        updateAdapterList()
    }

    private fun updateAdapterList() {
        adapter.submitList(viewModel.getListOfConfigs())
    }

    private fun openResult() {
        MainFragmentDirections.showResult(viewModel.fieldsConfig)
    }
}