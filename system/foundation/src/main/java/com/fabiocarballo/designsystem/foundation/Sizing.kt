package com.fabiocarballo.designsystem.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Sizing internal constructor(
    val scale0: Dp = 2.dp,
    val scale100: Dp = 4.dp,
    val scale200: Dp = 6.dp,
    val scale300: Dp = 8.dp,
    val scale400: Dp = 10.dp,
    val scale500: Dp = 12.dp,
    val scale550: Dp = 14.dp,
    val scale600: Dp = 16.dp,
    val scale650: Dp = 18.dp,
    val scale700: Dp = 20.dp,
    val scale750: Dp = 22.dp,
    val scale800: Dp = 24.dp,
    val scale850: Dp = 28.dp,
    val scale900: Dp = 32.dp,
    val scale950: Dp = 36.dp,
    val scale1000: Dp = 40.dp,
    val scale1200: Dp = 48.dp,
    val scale1400: Dp = 56.dp,
    val scale1600: Dp = 64.dp,
    val scale2400: Dp = 96.dp,
    val scale3200: Dp = 128.dp,
    val scale4800: Dp = 192.dp
)

internal val defaultSizing = Sizing()

/**
 * The LocalComposition that holds the definition of spacing for the design system
 * theme specification.
 *
 * You can read the values from it in order to customize the spacings of your components.
 */
internal val LocalSizing =
    staticCompositionLocalOf { defaultSizing }
