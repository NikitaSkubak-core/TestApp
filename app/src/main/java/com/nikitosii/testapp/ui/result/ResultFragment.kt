package com.nikitosii.testapp.ui.result

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD
import android.text.InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
import android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.color
import androidx.core.view.setPadding
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
import com.nikitosii.testapp.util.AttributeConstants.FONT
import com.nikitosii.testapp.util.AttributeConstants.FONTSIZE
import com.nikitosii.testapp.util.AttributeConstants.IDENTIFIER
import com.nikitosii.testapp.util.AttributeConstants.INPUT
import com.nikitosii.testapp.util.AttributeConstants.KEYBOARD_TYPE
import com.nikitosii.testapp.util.AttributeConstants.LEFT_PADDING
import com.nikitosii.testapp.util.AttributeConstants.LINES
import com.nikitosii.testapp.util.AttributeConstants.LINE_SPACE
import com.nikitosii.testapp.util.AttributeConstants.MAX_STROKES
import com.nikitosii.testapp.util.AttributeConstants.POSITION_X
import com.nikitosii.testapp.util.AttributeConstants.POSITION_XREL
import com.nikitosii.testapp.util.AttributeConstants.POSITION_Y
import com.nikitosii.testapp.util.AttributeConstants.POSITION_YREL
import com.nikitosii.testapp.util.AttributeConstants.RADIUS
import com.nikitosii.testapp.util.AttributeConstants.RIGHT_PADDING
import com.nikitosii.testapp.util.AttributeConstants.RIM_PADDING
import com.nikitosii.testapp.util.AttributeConstants.SCROLL
import com.nikitosii.testapp.util.AttributeConstants.SECURE_TEXT_ENTRY
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_OPACITY
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_RADIUS
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_RED
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
import com.nikitosii.testapp.util.ext.getColorInt
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
        it.configs.forEach { config ->
            val et = EditText(context)
            initViewBackground(et, config)
            initViewsTextAttributes(et, config)
            initViewSize(et, config)
            binding.clViewContainer.addView(et)
            initViewSize2(et, config)
        }
    }

    private fun initViewSize2(v: View, config: ConfigData) {
        val maxCoordinatesX = binding.clViewContainer.width
        val maxCoordinatesY = binding.clViewContainer.height
        val valueX = config.findIntOrElse(POSITION_X, 0)
        val valueY = config.findIntOrElse(POSITION_Y, 0)
        val endX = config.findIntOrElse(SIZE_WIDTH, 200)
        val endY = config.findIntOrElse(SIZE_HEIGHT, 200)
        val minEndX = config.findIntOrElse(SIZE_MIN_WIDTH, 200)
        val minEndY = config.findIntOrElse(SIZE_MIN_HEIGHT, 200)
        val relativeX = config.findValue(POSITION_XREL)
        val relativeY = config.findValue(POSITION_YREL)

        val viewParams = v.layoutParams
        viewParams.width = maxInt(endX, minEndX)
        viewParams.height = maxInt(endY, minEndY)
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
                "center" -> (maxCoordinatesX - valueX) / 2
                "right" -> maxCoordinatesX + valueX
                else -> valueX
            }
        )
        set.connect(
            v.id,
            ConstraintSet.TOP,
            binding.clViewContainer.id,
            ConstraintSet.TOP,
            when (relativeY) {
                "bottom" -> valueY
                "center" -> (maxCoordinatesY - valueY)
                "", "top" -> maxCoordinatesY + valueY
                else -> valueX
            }
        )
            set.applyTo(binding.clViewContainer)
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
                getColorState(borderColor)
            )
        et.background = drawable
        et.setText("Test background")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViewsTextAttributes(et: EditText, config: ConfigData) {
        et.textAlignment = when (config.findValue(ALIGN)) {
            "left", "" -> TextView.TEXT_ALIGNMENT_TEXT_START
            "center" -> TextView.TEXT_ALIGNMENT_CENTER
            "right" -> TextView.TEXT_ALIGNMENT_TEXT_END
            else -> TextView.TEXT_ALIGNMENT_TEXT_START
        }
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
            "NumberPad" -> if (!isSecureType) TYPE_CLASS_NUMBER else TYPE_NUMBER_VARIATION_PASSWORD
            "emailAddress" -> if (!isSecureType) TYPE_TEXT_VARIATION_EMAIL_ADDRESS else TYPE_TEXT_VARIATION_PASSWORD
            else -> if (!isSecureType) TYPE_TEXT_FLAG_IME_MULTI_LINE else TYPE_TEXT_VARIATION_PASSWORD
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
        if (et.isEnabled)
            et.maxLines = config.findIntOrElse(MAX_STROKES, 1)
        et.isVerticalScrollBarEnabled = config.findBoolean(SCROLL)
        et.setLineSpacing(config.findFloatOrElse(LINE_SPACE, 12.0f), 1.0f)
        et.setText("View text attribute checkasdad sda sdda dasda das asda d ada s daas dasad ad as daa da d")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViewSize(et: EditText, config: ConfigData) {

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
//        initShadow(et, config)
//        initUnderlineColor(et, config)
//        initURLConfig(et, config)
    }

    private fun initShadow(et: EditText, config: ConfigData) {
        val shadowWidth = config.findFloatOrElse(SHADOW_WIDTH, 0.0f)
        val shadowHeight = config.findFloatOrElse(SHADOW_HEIGHT, 0.0f)
        val minShadowWidth = config.findFloatOrElse(SHADOW_WIDTH, 0.0f)
        val minShadowHeight = config.findFloatOrElse(SHADOW_HEIGHT, 0.0f)
        et.setShadowLayer(
            config.findFloatOrElse(SHADOW_RADIUS, 0.0f),
            max(shadowWidth, minShadowWidth),
            max(shadowHeight, minShadowHeight),
            config.getColorInt(
                SHADOW_COLOR_RED,
                SHADOW_COLOR_GREEN,
                SHADOW_COLOR_GREEN,
                config.findValue(SHADOW_OPACITY)
            )
        )
    }

    private fun initUnderlineColor(et: EditText, config: ConfigData) {
        val color = config.getColorInt(
            UNDERLINE_COLOR_RED,
            UNDERLINE_COLOR_GREEN,
            UNDERLINE_COLOR_BLUE,
            "1",
            true,
            NOT_USABLE_NUMBER
        )
        if (color != -1)
            et.backgroundTintList = ColorStateList.valueOf(color)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initURLConfig(et: EditText, config: ConfigData) {
        val colorInt = config.getColorInt(
            URL_TEXT_COLOR_RED,
            URL_TEXT_COLOR_GREEN,
            URL_TEXT_COLOR_BLUE,
            "1",
            true,
            NOT_USABLE_NUMBER
        )
        if (colorInt != NOT_USABLE_NUMBER) {
            val color = ColorStateList.valueOf(colorInt)
            et.setLinkTextColor(color)
            val urlText = " ${config.findValue(URL_TEXT_CONTENT)}"
            val text = et.text.toString()
            val font = when (config.findValue(FONT)) {
                "Steagal-Regular" -> R.font.insigne_steagal_regular
                "Steagal-Medium" -> R.font.insigne_steagal_medium
                else -> null
            }
            val res = SpannableStringBuilder().apply {
                append(text)
                color(colorInt) {
                    append(urlText)
                }
            }
            if (font.isNotNull()) {
                val spannableString = SpannableString(res)
                val typeface = ResourcesCompat.getFont(requireContext(), font!!)
                spannableString.setSpan(
                    StyleSpan(typeface!!.style),
                    res.indexOf(urlText), res.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                et.setText(spannableString)
            }
        }
    }

    companion object {
        const val NOT_USABLE_NUMBER = -1
    }

    fun setCustomFontTypeSpan(
        context: Context,
        source: String?,
        startIndex: Int,
        endIndex: Int,
        font: Int,
        color: Int
    ): SpannableString {
        val spannableString = SpannableString(source)
        val typeface = ResourcesCompat.getFont(context, font)
        spannableString.setSpan(
            StyleSpan(typeface!!.style),
            startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }
}