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
    /**
     * DISPLAY
     */
    val displayXSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    val displaySmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp
    ),
    val displayMedium: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp
    ),
    val displayLarge: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp
    ),
    /**
     * HEADING
     */
    val headingXSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    val headingSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    val headingMedium: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    val headingLarge: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    val headingXLarge: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp
    ),
    val headingXXLarge: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp
    ),
    /**
     * LABEL
     */
    val labelXSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    val labelSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val labelMedium: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val labelLarge: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    /**
     * PARAGRAPH
     */
    val paragraphXSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    val paragraphSmall: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val paragraphMedium: TextStyle = TextStyle(
        fontFamily = Move,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val paragraphLarge: TextStyle = TextStyle(
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
