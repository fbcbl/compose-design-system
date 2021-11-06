package com.fabiocarballo.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    val display: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp
    ),
    val heading: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    val label: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val paragraph: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)

internal val Move = FontFamily(
    Font(R.font.move_bold, FontWeight.Bold),
    Font(R.font.move_medium)
)

/**
 * The LocalComposition that holds the definition of typography for the design system
 * theme specification.
 *
 * You can read the values from it in order to customize the typography of your components.
 */
internal val LocalTypography =
    staticCompositionLocalOf<Typography> { error("No typography provided") }
