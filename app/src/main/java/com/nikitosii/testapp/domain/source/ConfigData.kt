package com.nikitosii.testapp.domain.source

import android.os.Parcelable
import com.nikitosii.testapp.util.ext.isDoubleValid
import com.nikitosii.testapp.util.ext.isIntValid
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfigData(
    val data: MutableList<Config> = mutableListOf(
        Config(
            attributeText = "Align",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'left', 'center' and 'right'",
            isValid = { listOf("left", "center", "right", "").contains(it) }),
        Config(
            attributeText = "Background Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Background Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Background Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Border Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Border Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Border Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Border Width",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "BottomPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "Default Text",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "Default Text Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Default Text Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Default Text Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "ExecutionDelay",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = "ExecutionDelay",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = "FirstResponder",
            attributeType = AttributeType.BOOLEAN,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { it in 0..1 } }
        ),
        Config(
            attributeText = "Font",
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = "FontSize",
            attributeType = AttributeType.INT,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = "Identifier",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "Input",
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = "InputFieldHeightDynamic",
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "KeyboardType",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'NumberPad', 'emailAddress' and ''",
            isValid = { value -> listOf("", "NumberPad", "emailAddress").contains(value) }),
        Config(
            attributeText = "Left Padding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Lines",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "LineSpace",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "MaxStrokes",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "NextResponder",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "Position-X",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = "Position-Y",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        Config(
            attributeText = "Position-xRel",
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'left', 'right', 'center' or ''",
            isValid = { listOf("", "left", "center", "right").contains(it) }
        ),
        Config(
            attributeText = "Position-yRel",
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'top', 'bottom', 'center' or ''",
            isValid = { listOf("", "top", "center", "bottom").contains(it) }),
        Config(
            attributeText = "Radius",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "RightPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "RimPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Scroll",
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = "SecureTextEntry",
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        Config(
            attributeText = "Shadow Color-R",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Shadow Color-g",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Shadow Color-B",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "Shadow Offset",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Shadow Opacity",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric or empty",
            isValid = { it.isDoubleValid { it >= 0 } }),
        Config(
            attributeText = "Shadow Radius",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Shadow Height",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Shadow Width",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Shadow MinHeight",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "Shadow MinWidth",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "URL link",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "URL text Align",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'left', 'center' and 'right'",
            isValid = { listOf("left", "center", "right").contains(it) }),
        Config(
            attributeText = "URL text color R",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "URL text color G",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "URL text color B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "URL text Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "URL text Font",
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        Config(
            attributeText = "URL text FontSize",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it >= 0 } }),
        Config(
            attributeText = "URL text Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        Config(
            attributeText = "URL UnderLineColor R",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "UnderLineColor G",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "UnderLineColor B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        Config(
            attributeText = "UnderLineColor B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it >= 0 } }),

        )
): Parcelable