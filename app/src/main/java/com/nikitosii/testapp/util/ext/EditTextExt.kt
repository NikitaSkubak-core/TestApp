package com.nikitosii.testapp.util.ext

import android.content.Context
import android.graphics.Color
import android.text.Html
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.RelativeSizeSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.view.inputmethod.EditorInfo.IME_FLAG_NO_ENTER_ACTION
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.google.android.material.shape.MaterialShapeDrawable
import com.nikitosii.testapp.R
import com.nikitosii.testapp.domain.source.ConfigData
import com.nikitosii.testapp.ui.result.ResultFragment
import com.nikitosii.testapp.util.AttributeConstants
import com.nikitosii.testapp.util.AttributeConstants.NOT_USABLE_NUMBER
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_THICKNESS
import java.lang.Float

fun EditText.setPadding(config: ConfigData) {
    val rimPadding = config.findIntOrElse(AttributeConstants.RIM_PADDING, 0)
    val leftPadding = config.findIntOrElse(
        AttributeConstants.LEFT_PADDING,
        ResultFragment.NOT_USABLE_NUMBER
    )
    val rightPadding = config.findIntOrElse(
        AttributeConstants.RIGHT_PADDING,
        ResultFragment.NOT_USABLE_NUMBER
    )
    val bottomPadding = config.findIntOrElse(
        AttributeConstants.BOTTOM_PADDING,
        ResultFragment.NOT_USABLE_NUMBER
    )
    setPadding(rimPadding)
    setPadding(
        leftPadding.ifNegative(rimPadding),
        rightPadding.ifNegative(rimPadding),
        rimPadding,
        bottomPadding.ifNegative(rimPadding)
    )
}

fun EditText.setShadow(config: ConfigData) {
    val shadowWidth = config.findFloatOrElse(AttributeConstants.SHADOW_WIDTH, 0.0f)
    val shadowHeight = config.findFloatOrElse(AttributeConstants.SHADOW_HEIGHT, 0.0f)
    val minShadowWidth = config.findFloatOrElse(AttributeConstants.SHADOW_MIN_WIDTH, 0.0f)
    val minShadowHeight = config.findFloatOrElse(AttributeConstants.SHADOW_MIN_HEIGHT, 0.0f)
    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    val color = config.getColorHex(
        AttributeConstants.SHADOW_COLOR_RED,
        AttributeConstants.SHADOW_COLOR_GREEN,
        AttributeConstants.SHADOW_COLOR_BLUE,
        true
    )
    if (color.isNotEmpty())
        setShadowLayer(
            config.findFloatOrElse(AttributeConstants.SHADOW_RADIUS, 0.0f),
            Float.max(shadowWidth, minShadowWidth),
            Float.max(shadowHeight, minShadowHeight),
            Color.parseColor(color)
        )
}

fun EditText.setBackground(config: ConfigData) {
    val drawable = MaterialShapeDrawable()
    val backgroundColor = config.getColorHex(
        AttributeConstants.BACKGROUND_COLOR_RED,
        AttributeConstants.BACKGROUND_COLOR_GREEN,
        AttributeConstants.BACKGROUND_COLOR_BLUE,
        true,
        ResultFragment.NOT_USABLE_NUMBER
    )
    if (backgroundColor.isNotEmpty())
        drawable.fillColor = getColorState(backgroundColor)
    drawable.setCornerSize(config.findFloatOrElse(AttributeConstants.RADIUS, 0.0f))
    val borderColor = config.getColorHex(
        AttributeConstants.BORDER_COLOR_RED,
        AttributeConstants.BORDER_COLOR_GREEN,
        AttributeConstants.BACKGROUND_COLOR_BLUE,
        false
    )
    val borderWidth = config.findFloatOrElse(AttributeConstants.BORDER_WIDTH, 0.0f)
    if (borderWidth != 0.0f && borderColor.isNotEmpty())
        drawable.setStroke(
            borderWidth,
            getColorState(borderColor).defaultColor
        )
    background = drawable
}

fun EditText.setTextAttributes(config: ConfigData) {
    textAlignment = when (config.findValue(AttributeConstants.ALIGN)) {
        "left", "" -> TextView.TEXT_ALIGNMENT_TEXT_START
        "center" -> TextView.TEXT_ALIGNMENT_CENTER
        "right" -> TextView.TEXT_ALIGNMENT_TEXT_END
        else -> TextView.TEXT_ALIGNMENT_TEXT_START
    }
    isVerticalScrollBarEnabled = config.findBoolean(AttributeConstants.SCROLL)
    val defaultText = config.findValue(AttributeConstants.DEFAULT_TEXT)
    val text = config.findValue(AttributeConstants.CONTENT)
    val isInputType = config.findBoolean(AttributeConstants.INPUT)
    isEnabled = isInputType
    setText(text.ifEmpty { defaultText })
    setTextColor(config)
    setTextInputStyle(config)
    maxLines = config.findIntOrElse(AttributeConstants.LINES, 1)
    setLines(config.findIntOrElse(AttributeConstants.LINES, 1))
    ellipsize = TextUtils.TruncateAt.END
    setLineSpacing(config.findFloatOrElse(AttributeConstants.LINE_SPACE, 12.0f), 1.0f)
}

fun EditText.setTextColor(config: ConfigData) {
    val defaultTextColor = config.getColorHex(
        AttributeConstants.DEFAULT_TEXT_COLOR_RED,
        AttributeConstants.DEFAULT_TEXT_COLOR_GREEN,
        AttributeConstants.DEFAULT_TEXT_COLOR_BLUE,
        true,
        ResultFragment.NOT_USABLE_NUMBER
    )
    val textColor = config.getColorHex(
        AttributeConstants.COLOR_RED,
        AttributeConstants.COLOR_GREEN,
        AttributeConstants.COLOR_BLUE,
        true,
        ResultFragment.NOT_USABLE_NUMBER
    )
    when (true) {
        (defaultTextColor.isNotEmpty()) -> setTextColor(getColorState(defaultTextColor))
        (textColor.isNotEmpty()) -> setTextColor(getColorState(textColor))
        else -> {}
    }
}

fun EditText.setTextInputStyle(config: ConfigData) {
    textSize = config.findFloatOrElse(AttributeConstants.FONTSIZE, 28.0f)
    val isSecureType = config.findBoolean(AttributeConstants.SECURE_TEXT_ENTRY)
    isSingleLine = false
    imeOptions = IME_FLAG_NO_ENTER_ACTION
    inputType =
        TYPE_TEXT_FLAG_MULTI_LINE or when (config.findValue(AttributeConstants.KEYBOARD_TYPE)) {
            "NumberPad" -> if (!isSecureType) InputType.TYPE_CLASS_NUMBER else InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            "emailAddress" -> if (!isSecureType) InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS else InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS or InputType.TYPE_TEXT_VARIATION_PASSWORD
            else -> if (!isSecureType) TYPE_CLASS_TEXT else TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    val font = when (config.findValue(AttributeConstants.FONT)) {
        "Steagal-Regular" -> resources.getFont(R.font.insigne_steagal_regular)
        "Steagal-Medium" -> resources.getFont(R.font.insigne_steagal_medium)
        else -> null
    }
    if (font.isNotNull())
        typeface = font
}

fun EditText.setURLParameters(config: ConfigData, context: Context) {
    val colorHex = config.getColorHex(
        AttributeConstants.URL_TEXT_COLOR_RED,
        AttributeConstants.URL_TEXT_COLOR_GREEN,
        AttributeConstants.URL_TEXT_COLOR_BLUE,
        true,
        ResultFragment.NOT_USABLE_NUMBER
    )
    if (colorHex.isNotEmpty()) {
        val url = config.findValue(AttributeConstants.URL_LINK)
        val urlContent = config.findValue(AttributeConstants.URL_TEXT_CONTENT).ifEmpty { url }
        val etText = this.text
        var spannedText = SpannableString(etText)
        val additionalInfo =
            Html.fromHtml("<font color='$colorHex'><a href='$url'>$urlContent</a></font>")
        val resText = TextUtils.concat(spannedText, additionalInfo)
        spannedText = SpannableString(resText)
        spannedText.setSpan(
            RelativeSizeSpan(
                config.findFloatOrElse(
                    AttributeConstants.URL_TEXT_FONT_SIZE,
                    28.0f
                ) / config.findFloatOrElse(AttributeConstants.FONT, 28.0f)
            ),
            etText.length,
            resText.length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
        val font = when (config.findValue(AttributeConstants.URL_TEXT_FONT)) {
            "Steagal-Regular" -> R.font.insigne_steagal_regular
            "Steagal-Medium" -> R.font.insigne_steagal_medium
            else -> null
        }
        if (font.isNotNull()) {
            val fontType = ResourcesCompat.getFont(context, font!!)
            spannedText.setSpan(
                TypefaceSpan(fontType!!), etText.length,
                resText.length,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
        }
        val underline = config.findIntOrElse(UNDERLINE_THICKNESS, NOT_USABLE_NUMBER)
        if (underline != NOT_USABLE_NUMBER)
            spannedText.setSpan(
                UnderlineSpan(),
                0,
                etText.length - 1,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
        setText(spannedText)
    }
}