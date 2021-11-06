package com.fabiocarballo.designsystem.foundation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides Typography()
    ) {
        MaterialTheme {
            ProvideTextStyle(
                LocalTypography.current.paragraph,
                content = content
            )
        }
    }
}


object Theme {

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
