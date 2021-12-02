package com.fabiocarballo.designsystem.foundation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.fabiocarballo.designsystem.foundation.text.LocalContentColor

@Composable
fun Theme(
    isSystemInDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkMode) darkColors() else lightColors()

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalSizing provides Sizing(),
        LocalContentColor provides colors.contentPrimary,
        LocalTypography provides Typography()
    ) {
        /**
         * We are temporarily piggy-backing on Material. With time we will have
         * less and less dependencies - as the design system gets more mature.
         */
        MaterialTheme(
            colors = MaterialTheme.colors.copy(
                primary = LocalColors.current.accent,
                background = LocalColors.current.backgroundPrimary,
                onBackground = LocalColors.current.contentPrimary,
                isLight = !isSystemInDarkMode
            )
        ) {
            CompositionLocalProvider(
                androidx.compose.material.LocalContentColor provides LocalColors.current.contentPrimary
            ) {
                ProvideTextStyle(
                    LocalTypography.current.paragraphLarge,
                    content = content
                )
            }
        }
    }
}


object Theme {

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val sizing: Sizing
        @Composable
        @ReadOnlyComposable
        get() = LocalSizing.current
}
