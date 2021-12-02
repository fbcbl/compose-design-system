package com.fabiocarballo.designsystem.components.buttons.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.fabiocarballo.designsystem.foundation.Theme


@Composable
internal fun CoreButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    contentPadding: PaddingValues = ButtonDefaults.largeButtonContentPadding(),
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    textStyle: TextStyle = ButtonDefaults.largeButtonTextStyle(),
    content: @Composable RowScope.() -> Unit
) {

    ProvideTextStyle(value = textStyle) {
        androidx.compose.material.Button(
            content = content,
            onClick = onClick,
            modifier = modifier,
            elevation = null,
            enabled = enabled,
            colors = androidx.compose.material.ButtonDefaults.buttonColors(
                backgroundColor = colors.backgroundColor,
                contentColor = colors.contentColor,
                disabledContentColor = colors.disabledContentColor,
                disabledBackgroundColor = colors.disabledBackgroundColor
            ),
            shape = shape,
            contentPadding = contentPadding
        )
    }
}

@Composable
internal fun CoreIconButton(
    onClick: () -> Unit,
    size: Dp,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RectangleShape,
    contentPadding: PaddingValues = ButtonDefaults.largeButtonContentPadding(),
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .clip(shape)
            .background(colors.backgroundColor)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = false, radius = size)
            )
            .padding(contentPadding)
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Immutable
data class ButtonColors(
    val backgroundColor: Color,
    val contentColor: Color,
    val disabledBackgroundColor: Color,
    val disabledContentColor: Color
)

object ButtonDefaults {

    @Composable
    fun primaryButtonColors(
        backgroundColor: Color = Theme.colors.backgroundInversePrimary,
        contentColor: Color = Theme.colors.contentInversePrimary,
        disabledBackgroundColor: Color = Theme.colors.backgroundDisabled,
        disabledContentColor: Color = Theme.colors.contentDisabled
    ) = ButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun secondaryColors(
        backgroundColor: Color = Theme.colors.backgroundTertiary,
        contentColor: Color = Theme.colors.contentPrimary,
        disabledBackgroundColor: Color = Theme.colors.backgroundDisabled,
        disabledContentColor: Color = Theme.colors.contentDisabled
    ) = ButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun tertiaryColors(
        backgroundColor: Color = Color.Transparent,
        contentColor: Color = Theme.colors.contentPrimary,
        disabledBackgroundColor: Color = Theme.colors.backgroundDisabled,
        disabledContentColor: Color = Theme.colors.contentDisabled
    ) = ButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun smallButtonContentPadding(): PaddingValues =
        PaddingValues(
            horizontal = Theme.sizing.scale300,
            vertical = Theme.sizing.scale300
        )

    @Composable
    fun mediumButtonContentPadding(): PaddingValues =
        PaddingValues(
            horizontal = Theme.sizing.scale300,
            vertical = Theme.sizing.scale500
        )

    @Composable
    fun largeButtonContentPadding(): PaddingValues =
        PaddingValues(all = Theme.sizing.scale600)

    @Composable
    fun smallButtonTextStyle(): TextStyle =
        Theme.typography.labelSmall

    @Composable
    fun mediumButtonTextStyle(): TextStyle =
        Theme.typography.labelMedium

    @Composable
    fun largeButtonTextStyle(): TextStyle =
        Theme.typography.labelLarge

}

