package com.fabiocarballo.designsystem.foundation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun Theme(
    isSystemInDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkMode) darkColors() else lightColors()

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides Typography()
    ) {
        MaterialTheme(
            colors = MaterialTheme.colors.copy(
                primary = LocalColors.current.accent,
                background = LocalColors.current.backgroundPrimary,
                onBackground = LocalColors.current.contentPrimary,
                isLight = !isSystemInDarkMode
            )
        ) {
            CompositionLocalProvider(
                LocalContentColor provides LocalColors.current.contentPrimary
            ) {
                ProvideTextStyle(
                    LocalTypography.current.paragraph,
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
}
