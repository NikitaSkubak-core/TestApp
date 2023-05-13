package com.nikitosii.testapp.ui.result

import android.app.ActionBar.LayoutParams
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputFilter
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.View.NO_ID
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.get
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.nikitosii.testapp.databinding.FragmentResultBinding
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.FieldsConfig
import com.nikitosii.testapp.ui.base.BaseFragment
import com.nikitosii.testapp.util.AttributeConstants.EXECUTION_DELAY
import com.nikitosii.testapp.util.AttributeConstants.FIRST_RESPONDER
import com.nikitosii.testapp.util.AttributeConstants.IDENTIFIER
import com.nikitosii.testapp.util.AttributeConstants.INPUT_FIELD_HEIGHT_DYNAMIC
import com.nikitosii.testapp.util.AttributeConstants.MAX_STROKES
import com.nikitosii.testapp.util.AttributeConstants.NEXT_RESPONDER
import com.nikitosii.testapp.util.AttributeConstants.POSITION_X
import com.nikitosii.testapp.util.AttributeConstants.POSITION_XREL
import com.nikitosii.testapp.util.AttributeConstants.POSITION_Y
import com.nikitosii.testapp.util.AttributeConstants.POSITION_YREL
import com.nikitosii.testapp.util.AttributeConstants.SIZE_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_WIDTH
import com.nikitosii.testapp.util.annotation.RequiresViewModel
import com.nikitosii.testapp.util.ext.checkConfig
import com.nikitosii.testapp.util.ext.findBoolean
import com.nikitosii.testapp.util.ext.findDoubleOrElse
import com.nikitosii.testapp.util.ext.findIntOrElse
import com.nikitosii.testapp.util.ext.findValue
import com.nikitosii.testapp.util.ext.maxInt
import com.nikitosii.testapp.util.ext.onClick
import com.nikitosii.testapp.util.ext.setBackground
import com.nikitosii.testapp.util.ext.setPadding
import com.nikitosii.testapp.util.ext.setShadow
import com.nikitosii.testapp.util.ext.setTextAttributes
import com.nikitosii.testapp.util.ext.setURLParameters


@RequiresViewModel(ResultViewModel::class)
class ResultFragment : BaseFragment<ResultViewModel>() {
    private lateinit var binding: FragmentResultBinding
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribe()
        viewModel.fieldsConfig.value = args.configData
    }

    private fun initViews() {
        binding.btnBack.onClick {
            navController.popBackStack() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun subscribe() {
        with(viewModel) {
            fieldsConfig.observe(viewLifecycleOwner, fieldsConfigObserver)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val fieldsConfigObserver: Observer<FieldsConfig> = Observer {
        it.configs.forEachIndexed { index, config ->
            val et = EditText(context)
            et.setBackground(config)
            et.setPadding(config)
            et.setShadow(config)
//            et.setTextPaint(config)
            et.setTextAttributes(config)
            et.setURLParameters(config, requireContext())
            binding.clViewContainer.addView(et)
            initViewSize(index, et, config)
        }
        it.configs.forEachIndexed { index, config ->
            val view = binding.clViewContainer[index] as EditText
            setCursorMovements(index, view, config)
            if (checkConfig(it, NEXT_RESPONDER, it.configs.size - 1))
                initNextResponds(view, config)
            if (checkConfig(it, FIRST_RESPONDER, 1))
                initViewFirstFocuce(view, config)
        }
    }

    private fun initViewSize(id: Int, v: View, config: ConfigData) {
        val id = config.findIntOrElse(IDENTIFIER, id)
        v.id = id
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        val valueX = config.findIntOrElse(POSITION_X, 0)
        val valueY = config.findIntOrElse(POSITION_Y, 0)
        val endX = config.findIntOrElse(SIZE_WIDTH, 200)
        val endY = config.findIntOrElse(SIZE_HEIGHT, 0)
        val minEndX = config.findIntOrElse(SIZE_MIN_WIDTH, 200)
        val minEndY = config.findIntOrElse(SIZE_MIN_HEIGHT, 200)
        val relativeX = config.findValue(POSITION_XREL)
        val relativeY = config.findValue(POSITION_YREL)
        val isDynamicHeight = config.findBoolean(INPUT_FIELD_HEIGHT_DYNAMIC)
        val viewParams = v.layoutParams
        viewParams.width = maxInt(endX, minEndX)
        viewParams.height = maxInt(endY, minEndY)
        v.minimumWidth = minEndX
        v.minimumHeight = minEndY
        v.layoutParams = viewParams
        val set = ConstraintSet()
        set.clone(binding.clViewContainer)
        set.connect(
            v.id,
            ConstraintSet.LEFT,
            binding.clViewContainer.id,
            ConstraintSet.LEFT,
            when (relativeX) {
                "", "left" -> valueX
                "center" -> width / 2 - valueX
                "right" -> width + valueX
                else -> valueX
            }
        )
        if (isDynamicHeight || endY == 0) {
            viewParams.height = LayoutParams.WRAP_CONTENT
            v.layoutParams = viewParams
        } else {
            val coordinates = when (relativeY) {
                "", "top" -> valueY
                "center" -> height / 2 - valueY
                "bottom" -> height + valueY
                else -> valueX
            }
            set.connect(
                v.id,
                ConstraintSet.TOP,
                binding.clViewContainer.id,
                ConstraintSet.TOP,
                coordinates
            )
        }
        set.applyTo(binding.clViewContainer)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCursorMovements(index: Int, et: EditText, config: ConfigData) {
        val executionDelay = config.findDoubleOrElse(EXECUTION_DELAY, 0.0)
        et.doOnTextChanged { text, _, _, _ ->
            if (executionDelay != 0.0) {
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    focus(et, config, index, text.toString())
                }, (executionDelay * 100).toLong())
            } else focus(et, config, index, text.toString())
        }
    }

    private fun focus(et: EditText, config: ConfigData, id: Int, text: String) {
        val maxStroke = config.findIntOrElse(MAX_STROKES, NOT_USABLE_NUMBER)
        if (maxStroke != NOT_USABLE_NUMBER) {
            et.filters = arrayOf(InputFilter.LengthFilter(maxStroke))
            if (text.length == maxStroke)
                if (et.nextFocusDownId != NO_ID)
                    binding.clViewContainer.findViewById<EditText>(et.nextFocusDownId)
                        .requestFocus()
                else {
                    if (id < binding.clViewContainer.childCount - 1)
                        binding.clViewContainer[id + 1].requestFocus()
                }
        }
    }

    private fun initViewFirstFocuce(et: EditText, config: ConfigData) {
        if (config.findBoolean(FIRST_RESPONDER))
            et.requestFocus()
    }

    private fun initNextResponds(et: EditText, config: ConfigData) {
        et.nextFocusDownId = config.findIntOrElse(NEXT_RESPONDER, NO_ID)
    }

    companion object {
        const val NOT_USABLE_NUMBER = -1
    }
}