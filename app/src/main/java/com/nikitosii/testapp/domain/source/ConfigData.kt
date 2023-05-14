package com.nikitosii.testapp.domain.source

import android.os.Parcelable
import com.nikitosii.testapp.util.AttributeConstants.ALIGN
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.BACKGROUND_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.BORDER_COLOR_BLUE
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
import com.nikitosii.testapp.util.AttributeConstants.EXECUTION_DELAY
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
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_MIN_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_MIN_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_RADIUS
import com.nikitosii.testapp.util.AttributeConstants.SHADOW_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_HEIGHT
import com.nikitosii.testapp.util.AttributeConstants.SIZE_MIN_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.SIZE_WIDTH
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.UNDERLINE_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.URL_LINK
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_CONTENT
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_FONT
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_FONT_SIZE
import com.nikitosii.testapp.util.AttributeConstants.URL_UNDERLINE
import com.nikitosii.testapp.util.AttributeConstants.URL_UNDERLINE_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.URL_UNDERLINE_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.URL_UNDERLINE_COLOR_RED
import com.nikitosii.testapp.util.ext.isDoubleValid
import com.nikitosii.testapp.util.ext.isIntValid
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfigData(
    val data: MutableList<Config> = mutableListOf(
        Config(
            attributeText = ALIGN,
            attributeType = AttributeType.STRING_POSITION,
            isValid = { listOf("left", "center", "right", "").contains(it) }),
        Config(
            attributeText = BACKGROUND_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BACKGROUND_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BACKGROUND_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_WIDTH,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = BOTTOM_PADDING,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = CONTENT,
            attributeType = AttributeType.STRING,
            isValid = { true }),
        Config(
            attributeText = DEFAULT_TEXT,
            attributeType = AttributeType.STRING,
            isValid = { true }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = EXECUTION_DELAY,
            attributeType = AttributeType.DOUBLE,
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = FIRST_RESPONDER,
            attributeType = AttributeType.BOOLEAN,
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = FONT,
            attributeType = AttributeType.STRING_STYLE,
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = FONTSIZE,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = IDENTIFIER,
            attributeType = AttributeType.INT,
            isValid = { true }),
        Config(
            attributeText = INPUT,
            attributeType = AttributeType.BOOLEAN,
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = INPUT_FIELD_HEIGHT_DYNAMIC,
            attributeType = AttributeType.BOOLEAN,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = KEYBOARD_TYPE,
            attributeType = AttributeType.STRING_INPUT,
            isValid = { value -> listOf("", "NumberPad", "emailAddress").contains(value) }),
        Config(
            attributeText = LEFT_PADDING,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = LINES,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = LINE_SPACE,
            attributeType = AttributeType.DOUBLE,
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = MAX_STROKES,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = NEXT_RESPONDER,
            attributeType = AttributeType.STRING,
            isValid = { true }),
        Config(
            attributeText = POSITION_X,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = POSITION_Y,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = POSITION_XREL,
            attributeType = AttributeType.STRING_POSITION,
            isValid = { listOf("", "left", "center", "right").contains(it) }
        ),
        Config(
            attributeText = POSITION_YREL,
            attributeType = AttributeType.STRING_POSITION_Y,
            isValid = { listOf("", "top", "center", "bottom").contains(it) }),
        Config(
            attributeText = RADIUS,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = RIGHT_PADDING,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = RIM_PADDING,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SCROLL,
            attributeType = AttributeType.BOOLEAN,
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = SECURE_TEXT_ENTRY,
            attributeType = AttributeType.BOOLEAN,
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = SIZE_WIDTH,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_HEIGHT,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_MIN_WIDTH,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_MIN_HEIGHT,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_RADIUS,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_WIDTH,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_HEIGHT,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_MIN_WIDTH,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_MIN_HEIGHT,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = UNDERLINE,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = UNDERLINE_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = UNDERLINE_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = UNDERLINE_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_LINK,
            attributeType = AttributeType.STRING,
            isValid = { true }),
        Config(
            attributeText = URL_TEXT_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_CONTENT,
            attributeType = AttributeType.STRING,
            isValid = { true }),
        Config(
            attributeText = URL_TEXT_FONT,
            attributeType = AttributeType.STRING_STYLE,
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = URL_TEXT_FONT_SIZE,
            attributeType = AttributeType.INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = URL_UNDERLINE,
            attributeType = AttributeType.POSITIVE_INT,
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = URL_UNDERLINE_COLOR_RED,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_UNDERLINE_COLOR_GREEN,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_UNDERLINE_COLOR_BLUE,
            attributeType = AttributeType.COLOR_INT,
            isValid = { it.isIntValid { it in 0..255 } })
        )
) : Parcelable