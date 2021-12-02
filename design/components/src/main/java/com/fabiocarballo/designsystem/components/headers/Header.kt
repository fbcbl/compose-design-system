package com.fabiocarballo.designsystem.components.headers

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.LocalContentColor


@Composable
fun Header(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
    title: @Composable () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        contentColor = LocalContentColor.current,
        elevation = 0.dp,
        navigationIcon = navigationIcon,
        actions = actions,
        title = {
            ProvideTextStyle(
                value = Theme.typography.labelLarge
            ) {
                title()
            }
        }
    )
}
