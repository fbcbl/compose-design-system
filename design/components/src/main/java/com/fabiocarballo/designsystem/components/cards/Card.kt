package com.fabiocarballo.designsystem.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fabiocarballo.designsystem.foundation.Theme

@Composable
fun Card(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier
            .clickable(onClick = onClick)
            .border(
                width = Theme.sizing.scale0,
                color = Theme.colors.backgroundTertiary
            )
    ) {
        content()
    }
}
