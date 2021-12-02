package com.fabiocarballo.designsystem.components.progress

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fabiocarballo.designsystem.foundation.Theme

@Composable
fun Loader(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = Theme.colors.accent
    )
}
