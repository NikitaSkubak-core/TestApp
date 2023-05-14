package com.nikitosii.testapp.domain.source

enum class AttributeType(val errorMessage: String) {
    STRING("value must be string"),
    STRING_STYLE("please put the value 'Steagal-Regular' or 'Steagal-Medium', or just leave empty"),
    STRING_INPUT("Only 3 options are possible: 'NumberPad', 'emailAddress' and ''"),
    STRING_POSITION("Only 4 options are possible: 'left', 'center', 'right' and ''"),
    STRING_POSITION_Y("only 4 options are available: 'top', 'bottom', 'center' or ''"),
    INT("value must be numeric"),
    POSITIVE_INT("value must be positive numeric"),
    DOUBLE("value must be double"),
    BOOLEAN("the value should be as '0' (false), and '1' (true)"),
    COLOR_INT("the value should be as '0' (false), and '1' (true)")
}