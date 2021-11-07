package com.fabiocarballo.designsystem.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.buttons.internal.CoreButton

@Composable
fun TertiaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.mediumButtonContentPadding(),
    textStyle: TextStyle = ButtonDefaults.mediumButtonTextStyle(),
    content: @Composable RowScope.() -> Unit
) {
    CoreButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.tertiaryColors(),
        contentPadding = contentPadding,
        textStyle = textStyle,
        content = content
    )
}
