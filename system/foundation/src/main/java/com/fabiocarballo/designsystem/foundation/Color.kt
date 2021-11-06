package com.fabiocarballo.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors internal constructor(
    val primaryA: Color,
    val primaryB: Color,
    val accent: Color,
    val negative: Color,
    val warning: Color,
    val positive: Color,
    val backgroundPrimary: Color,
    val backgroundInversePrimary: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val backgroundDisabled: Color,
    val contentPrimary: Color,
    val contentInversePrimary: Color,
    val contentSecondary: Color,
    val contentTertiary: Color,
    val contentDisabled: Color
)

fun lightColors(
    primaryA: Color = GrayPalette.black,
    primaryB: Color = GrayPalette.white,
    accent: Color = BluePalette.blue400,
    negative: Color = RedPalette.red400,
    warning: Color = YellowPalette.yellow400,
    positive: Color = GreenPalette.green400,
    backgroundPrimary: Color = primaryB,
    backgroundInversePrimary: Color = primaryA,
    backgroundSecondary: Color = GrayPalette.gray50,
    backgroundTertiary: Color = GrayPalette.gray100,
    backgroundDisabled: Color = GrayPalette.gray50,
    contentPrimary: Color = primaryA,
    contentInversePrimary: Color = primaryB,
    contentSecondary: Color = GrayPalette.gray600,
    contentTertiary: Color = GrayPalette.gray500,
    contentDisabled: Color = GrayPalette.gray400
) = Colors(
    primaryA = primaryA,
    primaryB = primaryB,
    accent = accent,
    negative = negative,
    warning = warning,
    positive = positive,
    backgroundPrimary = backgroundPrimary,
    backgroundInversePrimary = backgroundInversePrimary,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    backgroundDisabled = backgroundDisabled,
    contentPrimary = contentPrimary,
    contentInversePrimary = contentInversePrimary,
    contentSecondary = contentSecondary,
    contentTertiary = contentTertiary,
    contentDisabled = contentDisabled
)

fun darkColors(
    primaryA: Color = GrayPalette.gray200,
    primaryB: Color = GrayPalette.gray900,
    accent: Color = BluePalette.blue400,
    negative: Color = RedPalette.red500,
    warning: Color = YellowPalette.yellow500,
    positive: Color = GreenPalette.green500,
    backgroundPrimary: Color = primaryB,
    backgroundInversePrimary: Color = primaryA,
    backgroundSecondary: Color = GrayPalette.gray800,
    backgroundTertiary: Color = GrayPalette.gray700,
    backgroundDisabled: Color = GrayPalette.gray800,
    contentPrimary: Color = primaryA,
    contentInversePrimary: Color = primaryB,
    contentSecondary: Color = GrayPalette.gray400,
    contentTertiary: Color = GrayPalette.gray500,
    contentDisabled: Color = GrayPalette.gray600
) = Colors(
    primaryA = primaryA,
    primaryB = primaryB,
    accent = accent,
    negative = negative,
    warning = warning,
    positive = positive,
    backgroundPrimary = backgroundPrimary,
    backgroundInversePrimary = backgroundInversePrimary,
    backgroundSecondary = backgroundSecondary,
    backgroundTertiary = backgroundTertiary,
    backgroundDisabled = backgroundDisabled,
    contentPrimary = contentPrimary,
    contentInversePrimary = contentInversePrimary,
    contentSecondary = contentSecondary,
    contentTertiary = contentTertiary,
    contentDisabled = contentDisabled
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
