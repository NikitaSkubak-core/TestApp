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
import com.nikitosii.testapp.util.AttributeConstants.URL_LINK
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_BLUE
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_GREEN
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_COLOR_RED
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_CONTENT
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_FONT
import com.nikitosii.testapp.util.AttributeConstants.URL_TEXT_FONT_SIZE
import com.nikitosii.testapp.util.ext.isDoubleValid
import com.nikitosii.testapp.util.ext.isIntValid
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfigData(
    val data: MutableList<Config> = mutableListOf(
        Config(
            attributeText = ALIGN,
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'left', 'center' and 'right'",
            isValid = { listOf("left", "center", "right", "").contains(it) }),
        Config(
            attributeText = BACKGROUND_COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BACKGROUND_COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BACKGROUND_COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = BORDER_WIDTH,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = BOTTOM_PADDING,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = CONTENT,
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = DEFAULT_TEXT,
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = DEFAULT_TEXT_COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = EXECUTION_DELAY,
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = FIRST_RESPONDER,
            attributeType = AttributeType.BOOLEAN,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { it in 0..1 } }
        ),
        Config(
            attributeText = FONT,
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = FONTSIZE,
            attributeType = AttributeType.INT,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = IDENTIFIER,
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = INPUT,
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = INPUT_FIELD_HEIGHT_DYNAMIC,
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = KEYBOARD_TYPE,
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'NumberPad', 'emailAddress' and ''",
            isValid = { value -> listOf("", "NumberPad", "emailAddress").contains(value) }),
        Config(
            attributeText = LEFT_PADDING,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = LINES,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = LINE_SPACE,
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = MAX_STROKES,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = NEXT_RESPONDER,
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = POSITION_X,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = POSITION_Y,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = POSITION_XREL,
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'left', 'right', 'center' or ''",
            isValid = { listOf("", "left", "center", "right").contains(it) }
        ),
        Config(
            attributeText = POSITION_YREL,
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'top', 'bottom', 'center' or ''",
            isValid = { listOf("", "top", "center", "bottom").contains(it) }),
        Config(
            attributeText = RADIUS,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = RIGHT_PADDING,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = RIM_PADDING,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SCROLL,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = SECURE_TEXT_ENTRY,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = SIZE_WIDTH,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric, >= 0 or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_HEIGHT,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric, >= 0 or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_MIN_WIDTH,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric, >= 0 or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SIZE_MIN_HEIGHT,
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric, >= 0 or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric, from 0 to 255 or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric, from 0 to 255 or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric, from 0 to 255 or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = SHADOW_RADIUS,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_HEIGHT,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_WIDTH,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_MIN_HEIGHT,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = SHADOW_MIN_WIDTH,
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = URL_LINK,
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = URL_TEXT_COLOR_RED,
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_COLOR_GREEN,
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_COLOR_BLUE,
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = URL_TEXT_CONTENT,
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = URL_TEXT_FONT,
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = URL_TEXT_FONT_SIZE,
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it >= 0 } }),

        )
) : Parcelable