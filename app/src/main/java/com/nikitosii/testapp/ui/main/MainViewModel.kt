package com.nikitosii.testapp.ui.main

import androidx.lifecycle.ViewModel
import com.nikitosii.testapp.domain.source.AttributeType
import com.nikitosii.testapp.domain.source.TextFieldConfig
import com.nikitosii.testapp.util.ext.isDoubleValid
import com.nikitosii.testapp.util.ext.isIntValid
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val textFieldsList = mutableListOf(
        TextFieldConfig(
            attributeText = "Align",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'left', 'center' and 'right'",
            isValid = { listOf("left", "center", "right", "").contains(it) }),
        TextFieldConfig(
            attributeText = "Background Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Background Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Background Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Border Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Border Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Border Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric from 0 to 255",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Border Width",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "BottomPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "Default Text",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "Default Text Color Red",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Default Text Color Green",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Default Text Color Blue",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "ExecutionDelay",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isDoubleValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "ExecutionDelay",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isDoubleValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "FirstResponder",
            attributeType = AttributeType.BOOLEAN,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { it in 0..1 } }
        ),
        TextFieldConfig(
            attributeText = "Font",
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        TextFieldConfig(
            attributeText = "FontSize",
            attributeType = AttributeType.INT,
            errorText = "the value should be as '0' (false), and '1' (true)",
            isValid = { it.isIntValid { true } }),
        TextFieldConfig(
            attributeText = "Identifier",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "Input",
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..1 } }),
        TextFieldConfig(
            attributeText = "InputFieldHeightDynamic",
            attributeType = AttributeType.BOOLEAN,
            errorText = "",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "KeyboardType",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'NumberPad', 'emailAddress' and ''",
            isValid = { value -> listOf("", "NumberPad", "emailAddress").contains(value) }),
        TextFieldConfig(
            attributeText = "Left Padding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Lines",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "LineSpace",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "MaxStrokes",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "NextResponder",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "Position-X",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        TextFieldConfig(
            attributeText = "Position-Y",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric",
            isValid = { it.isIntValid { true } }),
        TextFieldConfig(
            attributeText = "Position-xRel",
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'left', 'right', 'center' or ''",
            isValid = { listOf("", "left", "center", "right").contains(it) }
        ),
        TextFieldConfig(
            attributeText = "Position-yRel",
            attributeType = AttributeType.STRING,
            errorText = "only 4 options are available: 'top', 'bottom', 'center' or ''",
            isValid = { listOf("", "top", "center", "bottom").contains(it) }),
        TextFieldConfig(
            attributeText = "Radius",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "RightPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "RimPadding",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Scroll",
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        TextFieldConfig(
            attributeText = "SecureTextEntry",
            attributeType = AttributeType.BOOLEAN,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..1 } }),
        TextFieldConfig(
            attributeText = "Shadow Color-R",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Shadow Color-g",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Shadow Color-B",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it in 0..255 } }),
        TextFieldConfig(
            attributeText = "Shadow Offset",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow Opacity",
            attributeType = AttributeType.DOUBLE,
            errorText = "value must be numeric or empty",
            isValid = { it.isDoubleValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow Radius",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow Height",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow Width",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow MinHeight",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "Shadow MinWidth",
            attributeType = AttributeType.INT,
            errorText = "value must be numeric or empty",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "URL link",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "URL text Align",
            attributeType = AttributeType.STRING,
            errorText = "Only 3 options are possible: 'left', 'center' and 'right'",
            isValid = { listOf("left", "center", "right").contains(it) }),
        TextFieldConfig(
            attributeText = "URL text color R",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "URL text color G",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "URL text color B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "URL text Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "URL text Font",
            attributeType = AttributeType.STRING,
            errorText = "please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty",
            isValid = { listOf("Steagal-Regular", "Steagal-Medium", "").contains(it) }),
        TextFieldConfig(
            attributeText = "URL text FontSize",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it >= 0 } }),
        TextFieldConfig(
            attributeText = "URL text Content",
            attributeType = AttributeType.STRING,
            errorText = "",
            isValid = { true }),
        TextFieldConfig(
            attributeText = "URL UnderLineColor R",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "UnderLineColor G",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "UnderLineColor B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it in 0 .. 255 } }),
        TextFieldConfig(
            attributeText = "UnderLineColor B",
            attributeType = AttributeType.INT,
            errorText = "",
            isValid = { it.isIntValid { it >= 0} }),

    )

}

