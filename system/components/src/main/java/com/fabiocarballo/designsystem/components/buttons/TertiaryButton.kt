package com.fabiocarballo.designsystem.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.buttons.internal.CoreButton
import com.fabiocarballo.designsystem.components.icons.Icon
import com.fabiocarballo.designsystem.foundation.Theme

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

@Composable
fun TertiaryIconButton(
    onClick: () -> Unit,
    painter: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = ButtonIconSize.Medium.iconSize(),
    enabled: Boolean = true,
) {
    TertiaryButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        contentPadding = PaddingValues(Theme.sizing.scale500)
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
    }
}

sealed class ButtonIconSize {

    @Composable
    abstract fun iconSize(): Dp

    object Small : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale600
    }

    object Medium : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale700
    }

    object Large : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale800
    }
}

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE
}
