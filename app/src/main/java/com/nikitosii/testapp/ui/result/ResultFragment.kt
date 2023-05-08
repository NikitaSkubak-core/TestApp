package com.nikitosii.testapp.ui.result

import android.app.ActionBar.LayoutParams
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType.TYPE_CLASS_NUMBER
import android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD
import android.text.InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
import android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.text.SpannableStringBuilder
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.View.NO_ID
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.text.color
import androidx.core.text.htmlEncode
import androidx.core.view.get
import androidx.core.view.setPadding
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.shape.MaterialShapeDrawable
import com.nikitosii.testapp.R
import com.nikitosii.testapp.databinding.FragmentResultBinding
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.domain.source.FieldsConfig
import com.nikitosii.testapp.ui.base.BaseFragment
import com.nikitosii.testapp.util.AttributeConstants.ALIGN
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.BORDER_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.BORDER_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.BORDER_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.BOTTOM_PADDING
import com.nikitosii.testapp.util.AttributeConstants.COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.CONTENT
import com.nikitosii.testapp.util.AttributeConstants.DEFAULT_TEXT
import com.nikitosii.testapp.util.AttributeConstants.DEFAULT_TEXT_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.DEFAULT_TEXT_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.DEFAULT_TEXT_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.FIRST_RESPONDER
import com.nikitosii.testapp.util.AttributeConstants.FONT
import com.nikitosii.testapp.util.AttributeConstants.FONTSIZE
import com.nikitosii.testapp.util.AttributeConstants.IDENTIFIER
import com.nikitosii.testapp.util.AttributeConstants.INPUT
import com.nikitosii.testapp.util.AttributeConstants.INPUT_FIELD_HEIGHT_DYNAMIC
import com.nikitosii.testapp.util.AttributeConstants.KEYBOARD_TYPE
import com.nikitosii.testapp.util.AttributeConstants.LEFT_PADDING
import com.nikitosii.testapp.util.AttributeConstants.LINES
import com.nikitosii.testapp.util.AttributeConstants.LINE_SPACE
import com.nikitosii.testapp.util.AttributeConstants.MAX_STROKES
import com.nikitosii.testapp.util.AttributeConstants.NEXT_RESPONDER
import com.nikitosii.testapp.util.AttributeConstants.POSITION_X
import com.nikitosii.testapp.util.AttributeConstants.POSITION_XREL
import com.nikitosii.testapp.util.AttributeConstants.POSITION_Y
import com.nikitosii.testapp.util.AttributeConstants.POSITION_YREL
import com.nikitosii.testapp.util.AttributeConstants.RADIUS
import com.nikitosii.testapp.util.AttributeConstants.RIGHT_PADDING
import com.nikitosii.testapp.util.AttributeConstants.RIM_PADDING
import com.nikitosii.testapp.util.AttributeConstants.SCROLL
import com.nikitosii.testapp.util.AttributeConstants.SECURE_TEXT_ENTRY
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_RADIUS
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.URL_LINK
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_CONTENT
import com.nikitosii.testapp.util.annotation.RequiresViewModel
import com.nikitosii.testapp.util.ext.findBoolean
import com.nikitosii.testapp.util.ext.findFloatOrElse
import com.nikitosii.testapp.util.ext.findIntOrElse
import com.nikitosii.testapp.util.ext.findValue
import com.nikitosii.testapp.util.ext.getColorHex
import com.nikitosii.testapp.util.ext.getColorState
import com.nikitosii.testapp.util.ext.ifNegative
import com.nikitosii.testapp.util.ext.isNotNull
import com.nikitosii.testapp.util.ext.maxInt
import com.nikitosii.testapp.util.ext.onClick
import java.lang.Float.max


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
        binding.btnBack.onClick { navController.popBackStack() }
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
            initViewBackground(et, config)

            initViewPadding(et, config)
            initShadow(et, config)
            initURLConfig(et, config)
            binding.clViewContainer.addView(et)
            initViewSize(index, et, config)
        }
        if ((it.configs.map { it.findValue(NEXT_RESPONDER) }.size == it.configs.size))
            it.configs.forEachIndexed { index, configData ->
                initNextResponds(binding.clViewContainer[index] as EditText, configData)
            }
        if (it.configs.filter { it.findBoolean(FIRST_RESPONDER) }.size == 1)
            it.configs.forEachIndexed { index, configData ->
                initViewFirstFocuce(binding.clViewContainer.get(index) as EditText, configData)
            }
        it.configs.forEachIndexed{index, config ->
            initViewsTextAttributes(index, binding.clViewContainer[index] as EditText, config)
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
        val endY = config.findIntOrElse(SIZE_HEIGHT, 200)
        val minEndX = config.findIntOrElse(SIZE_MIN_WIDTH, 200)
        val minEndY = config.findIntOrElse(SIZE_MIN_HEIGHT, 200)
        val relativeX = config.findValue(POSITION_XREL)
        val relativeY = config.findValue(POSITION_YREL)
        val isDynamicHeight = config.findBoolean(INPUT_FIELD_HEIGHT_DYNAMIC)
        val viewParams = v.layoutParams
        viewParams.width = maxInt(endX, minEndX)
        viewParams.height = maxInt(endY, minEndY)
        v.layoutParams = viewParams
        v.minimumHeight = minEndY
        v.minimumWidth = minEndX
        val set = ConstraintSet()
        set.clone(binding.clViewContainer)
        set.connect(
            v.id,
            ConstraintSet.LEFT,
            binding.clViewContainer.id,
            ConstraintSet.LEFT,
            when (relativeX) {
                "", "left" -> valueX
                "center" -> (width - valueX) / 2
                "right" -> width + valueX
                else -> valueX
            }
        )
        if (!isDynamicHeight) {
            val coordinates = when (relativeY) {
                "", "top" -> valueY
                "center" -> (height - valueY) / 2
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
            set.applyTo(binding.clViewContainer)
        } else v.layoutParams.height = LayoutParams.WRAP_CONTENT
    }

    private fun initViewBackground(et: EditText, config: ConfigData) {
        val drawable = MaterialShapeDrawable()
        val backgroundColor = config.getColorHex(
            BACKGROUND_COLOR_RED,
            BACKGROUND_COLOR_GREEN,
            BACKGROUND_COLOR_BLUE,
            true,
            NOT_USABLE_NUMBER
        )
        if (backgroundColor.isNotEmpty())
            drawable.fillColor = getColorState(backgroundColor)
        drawable.setCornerSize(config.findFloatOrElse(RADIUS, 0.0f))
        val borderColor = config.getColorHex(
            BORDER_COLOR_RED,
            BORDER_COLOR_GREEN,
            BACKGROUND_COLOR_BLUE,
            false
        )
        val borderWidth = config.findFloatOrElse(BORDER_WIDTH, 0.0f)
        if (borderWidth != 0.0f && borderColor.isNotEmpty())
            drawable.setStroke(
                borderWidth,
                getColorState(borderColor).defaultColor
            )
        et.background = drawable
        et.setText("Test background")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViewsTextAttributes(index: Int, et: EditText, config: ConfigData) {
        et.textAlignment = when (config.findValue(ALIGN)) {
            "left", "" -> TextView.TEXT_ALIGNMENT_TEXT_START
            "center" -> TextView.TEXT_ALIGNMENT_CENTER
            "right" -> TextView.TEXT_ALIGNMENT_TEXT_END
            else -> TextView.TEXT_ALIGNMENT_TEXT_START
        }
        et.isVerticalScrollBarEnabled = config.findBoolean(SCROLL)
        et.id = config.findIntOrElse(IDENTIFIER, 0)
        val defaultText = config.findValue(DEFAULT_TEXT)
        val text = config.findValue(CONTENT)
        val isInputType = config.findBoolean(INPUT)
        if (!isInputType) {
            et.setText(defaultText.ifEmpty { text })
        }
        val defaultTextColor = config.getColorHex(
            DEFAULT_TEXT_COLOR_RED,
            DEFAULT_TEXT_COLOR_GREEN,
            DEFAULT_TEXT_COLOR_BLUE,
            true,
            NOT_USABLE_NUMBER
        )
        val textColor = config.getColorHex(
            COLOR_RED,
            COLOR_GREEN,
            COLOR_BLUE,
            true,
            NOT_USABLE_NUMBER
        )
        when (true) {
            (defaultTextColor.isNotEmpty()) -> et.setTextColor(getColorState(defaultTextColor))
            (textColor.isNotEmpty()) -> et.setTextColor(getColorState(textColor))
            else -> {}
        }
        et.textSize = config.findFloatOrElse(FONTSIZE, 28.0f)
        val isSecureType = config.findBoolean(SECURE_TEXT_ENTRY)
        et.inputType = when (config.findValue(KEYBOARD_TYPE)) {
            "NumberPad" -> if (!isSecureType) TYPE_CLASS_NUMBER else TYPE_CLASS_NUMBER or TYPE_NUMBER_VARIATION_PASSWORD
            "emailAddress" -> if (!isSecureType) TYPE_TEXT_VARIATION_EMAIL_ADDRESS else TYPE_TEXT_VARIATION_EMAIL_ADDRESS or TYPE_TEXT_VARIATION_PASSWORD
            else -> if (!isSecureType) TYPE_TEXT_FLAG_IME_MULTI_LINE else TYPE_TEXT_FLAG_IME_MULTI_LINE or TYPE_TEXT_VARIATION_PASSWORD
        }
        val font = when (config.findValue(FONT)) {
            "Steagal-Regular" -> resources.getFont(R.font.insigne_steagal_regular)
            "Steagal-Medium" -> resources.getFont(R.font.insigne_steagal_medium)
            else -> null
        }
        if (font.isNotNull())
            et.typeface = font
        // TODO check what lines must do, looks like we need to initialize size
        et.setLines(config.findIntOrElse(LINES, 1))
        if (et.isEnabled) {
            val maxStroke = config.findIntOrElse(MAX_STROKES, NOT_USABLE_NUMBER)
            if (maxStroke != NOT_USABLE_NUMBER) {
                et.filters = arrayOf(InputFilter.LengthFilter(maxStroke))
                et.doOnTextChanged { text, _, _, _ ->
                    if (text?.length == maxStroke)
                        if (et.nextFocusDownId != NO_ID)
                        binding.clViewContainer.findViewById<EditText>(et.nextFocusDownId)
                            .requestFocus()
                    else {
                        if (index < binding.clViewContainer.childCount - 1)
                            binding.clViewContainer[index + 1].requestFocus()
                        }
                }
            }
        }

        et.isVerticalScrollBarEnabled = config.findBoolean(SCROLL)
        et.setLineSpacing(config.findFloatOrElse(LINE_SPACE, 12.0f), 1.0f)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViewPadding(et: EditText, config: ConfigData) {

        val rimPadding = config.findIntOrElse(RIM_PADDING, 0)
        val leftPadding = config.findIntOrElse(LEFT_PADDING, NOT_USABLE_NUMBER)
        val rightPadding = config.findIntOrElse(RIGHT_PADDING, NOT_USABLE_NUMBER)
        val bottomPadding = config.findIntOrElse(BOTTOM_PADDING, NOT_USABLE_NUMBER)
        et.setPadding(rimPadding)
        et.setPadding(
            leftPadding.ifNegative(rimPadding),
            rightPadding.ifNegative(rimPadding),
            rimPadding,
            bottomPadding.ifNegative(rimPadding)
        )

    }

    private fun initShadow(et: EditText, config: ConfigData) {
        val shadowWidth = config.findFloatOrElse(SHADOW_WIDTH, 0.0f)
        val shadowHeight = config.findFloatOrElse(SHADOW_HEIGHT, 0.0f)
        val minShadowWidth = config.findFloatOrElse(SHADOW_WIDTH, 0.0f)
        val minShadowHeight = config.findFloatOrElse(SHADOW_HEIGHT, 0.0f)
        et.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        val color = config.getColorHex(
            SHADOW_COLOR_RED,
            SHADOW_COLOR_GREEN,
            SHADOW_COLOR_BLUE
        )
        if (color.isNotEmpty())
            et.setShadowLayer(
                config.findFloatOrElse(SHADOW_RADIUS, 0.0f),
                max(shadowWidth, minShadowWidth),
                max(shadowHeight, minShadowHeight),
                Color.parseColor(color)
            )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initURLConfig(et: EditText, config: ConfigData) {
        val colorInt = config.getColorHex(
            URL_TEXT_COLOR_RED,
            URL_TEXT_COLOR_GREEN,
            URL_TEXT_COLOR_BLUE,
            true,
            NOT_USABLE_NUMBER
        )
        if (colorInt.isNotEmpty()) {
            val color = getColorState(colorInt)
            et.setLinkTextColor(color)
            val url = config.findValue(URL_LINK)
            val text = config.findValue(URL_TEXT_CONTENT)
            et.text = SpannableStringBuilder().apply {
                if (text.isNotEmpty()) append("<a href='$url'>$text</a>".htmlEncode())
                else append(" $url")
                color(Color.parseColor(colorInt)) {
                    append(url)
                }
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