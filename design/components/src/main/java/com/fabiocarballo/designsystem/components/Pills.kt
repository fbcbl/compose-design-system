package com.fabiocarballo.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonColors
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.buttons.internal.CoreButton
import com.fabiocarballo.designsystem.foundation.Theme

@Composable
fun SecondaryPill(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {

    CorePill(
        onClick = onClick,
        colors = ButtonDefaults.secondaryColors(),
        content = content,
        modifier = modifier
    )
}

@Composable
fun TertiaryPill(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {

    CorePill(
        onClick = onClick,
        colors = ButtonDefaults.tertiaryColors(),
        content = content,
        modifier = modifier
    )
}

@Composable
private fun CorePill(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    content: @Composable RowScope.() -> Unit
) {
    CoreButton(
        onClick = onClick,
        shape = RoundedCornerShape(100f),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier,
        colors = colors
    ) {
        ProvideTextStyle(
            value = Theme.typography.labelMedium.copy(fontSize = 14.sp),
        ) {
            content()
        }
    }
}
