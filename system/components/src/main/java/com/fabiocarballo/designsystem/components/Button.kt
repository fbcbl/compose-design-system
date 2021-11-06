package com.fabiocarballo.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.foundation.Theme

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {

    ProvideTextStyle(value = Theme.typography.label) {
        androidx.compose.material.Button(
            content = content,
            onClick = onClick,
            modifier = modifier,
            elevation = null,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.backgroundInversePrimary,
                contentColor = Theme.colors.contentInversePrimary,
                disabledBackgroundColor = Theme.colors.backgroundDisabled,
                disabledContentColor = Theme.colors.contentDisabled
            ),
            shape = RectangleShape,
            contentPadding = PaddingValues(
                vertical = 16.dp,
                horizontal = 8.dp
            )
        )
    }
}
