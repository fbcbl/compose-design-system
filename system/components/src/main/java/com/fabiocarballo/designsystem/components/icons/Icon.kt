package com.fabiocarballo.designsystem.components.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.fabiocarballo.designsystem.foundation.text.LocalContentColor

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    androidx.compose.material.Icon(
        modifier = modifier,
        painter = painter,
        tint = tint,
        contentDescription = contentDescription
    )
}
