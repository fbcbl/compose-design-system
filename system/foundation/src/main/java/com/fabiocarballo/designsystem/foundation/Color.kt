package com.fabiocarballo.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors internal constructor(
    val primaryA: Color = GrayPalette.black,
    val primaryB: Color = GrayPalette.white,
    val accent: Color = BluePalette.blue400,
    val negative: Color = RedPalette.red400,
    val warning: Color = YellowPalette.yellow400,
    val positive: Color = GreenPalette.green400,
    val backgroundPrimary: Color = primaryB,
    val backgroundSecondary: Color = GrayPalette.gray50,
    val backgroundTertiary: Color = GrayPalette.gray100,
    val contentPrimary: Color = primaryA,
    val contentSecondary: Color = GrayPalette.gray600,
    val contentTertiary: Color = GrayPalette.gray500
)

fun lightColors(
    primaryA: Color = GrayPalette.black,
    primaryB: Color = GrayPalette.white,
    accent: Color = BluePalette.blue400,
    negative: Color = RedPalette.red400,
    warning: Color = YellowPalette.yellow400,
    positive: Color = GreenPalette.green400,
    backgroundPrimary: Color = primaryB,
    backgroundSecondary: Color = GrayPalette.gray50,
    backgroundTertiary: Color = GrayPalette.gray100,
    contentPrimary: Color = primaryA,
    contentSecondary: Color = GrayPalette.gray600,
    contentTertiary: Color = GrayPalette.gray500
) = Colors(
    primaryA = primaryA,
    primaryB = primaryB,
    accent = accent,
    negative = negative,
    warning = warning,
    positive = positive,
    backgroundPrimary = backgroundPrimary,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    contentPrimary = contentPrimary,
    contentSecondary = contentSecondary,
    contentTertiary = contentTertiary
)

fun darkColors(
    primaryA: Color = GrayPalette.gray200,
    primaryB: Color = GrayPalette.gray900,
    accent: Color = BluePalette.blue400,
    negative: Color = RedPalette.red500,
    warning: Color = YellowPalette.yellow500,
    positive: Color = GreenPalette.green500,
    backgroundPrimary: Color = primaryB,
    backgroundSecondary: Color = GrayPalette.gray800,
    backgroundTertiary: Color = GrayPalette.gray700,
    contentPrimary: Color = primaryA,
    contentSecondary: Color = GrayPalette.gray400,
    contentTertiary: Color = GrayPalette.gray500
) = Colors(
    primaryA = primaryA,
    primaryB = primaryB,
    accent = accent,
    negative = negative,
    warning = warning,
    positive = positive,
    backgroundPrimary = backgroundPrimary,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    contentPrimary = contentPrimary,
    contentSecondary = contentSecondary,
    contentTertiary = contentTertiary
)

private object GrayPalette {

    val black = Color(0xFF000000)
    val gray50 = Color(0xFFF6F6F6)
    val gray100 = Color(0xFFEEEEEE)
    val gray200 = Color(0xFFE2E2E2)
    val gray400 = Color(0xFFAFAFAF)
    val gray500 = Color(0xFF757575)
    val gray600 = Color(0xFF545454)
    val gray700 = Color(0xFF333333)
    val gray800 = Color(0xFF1F1F1F)
    val gray900 = Color(0xFF141414)
    val white = Color(0xFFFFFFFF)
}

private object BluePalette {
    val blue400 = Color(0xFF276EF1)
}

private object RedPalette {
    val red400 = Color(0xFFE11900)
    val red500 = Color(0xFFAB1300)
}

private object YellowPalette {
    val yellow400 = Color(0xFFFFC043)
    val yellow500 = Color(0xFFBC8B2C)

}

private object GreenPalette {
    val green400 = Color(0xFF05944F)
    val green500 = Color(0xFF03703C)
}

/**
 * The LocalComposition that holds the definition of colors for the design system
 * theme specification.
 *
 * You can read the values from it in order to customize the colors of your components.
 */
internal val LocalColors =
    staticCompositionLocalOf<Colors> { error("No colors provided") }
