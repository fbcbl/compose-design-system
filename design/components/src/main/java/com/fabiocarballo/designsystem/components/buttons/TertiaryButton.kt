package com.fabiocarballo.designsystem.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.buttons.internal.CoreButton
import com.fabiocarballo.designsystem.components.buttons.internal.CoreIconButton
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
    contentPadding: PaddingValues = ButtonIconSize.Medium.contentPadding(),
    enabled: Boolean = true,
) {
    CoreIconButton(
        onClick = onClick,
        size = iconSize,
        enabled = enabled,
        contentPadding = contentPadding,
        modifier = modifier,
        colors = ButtonDefaults.tertiaryColors()
    ) {
        Icon(
            painter = painter,
            contentDescription = null
        )
    }
}

sealed class ButtonIconSize {

    @Composable
    abstract fun iconSize(): Dp

    @Composable
    abstract fun contentPadding(): PaddingValues

    object Small : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale600

        @Composable
        override fun contentPadding(): PaddingValues = PaddingValues(Theme.sizing.scale400)
    }

    object Medium : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale700

        @Composable
        override fun contentPadding(): PaddingValues = PaddingValues(Theme.sizing.scale500)
    }

    object Large : ButtonIconSize() {

        @Composable
        override fun iconSize(): Dp = Theme.sizing.scale800

        @Composable
        override fun contentPadding(): PaddingValues = PaddingValues(Theme.sizing.scale600)
    }
}

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE
}
