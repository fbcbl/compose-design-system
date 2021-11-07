package com.fabiocarballo.designsystem.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.buttons.internal.CoreButton

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.largeButtonContentPadding(),
    textStyle: TextStyle = ButtonDefaults.largeButtonTextStyle(),
    content: @Composable RowScope.() -> Unit
) {
    CoreButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.primaryButtonColors(),
        enabled = enabled,
        contentPadding = contentPadding,
        textStyle = textStyle,
        content = content
    )
}
