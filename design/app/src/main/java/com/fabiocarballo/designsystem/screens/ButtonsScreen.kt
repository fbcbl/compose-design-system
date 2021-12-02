package com.fabiocarballo.designsystem.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.fabiocarballo.designsystem.R
import com.fabiocarballo.designsystem.components.buttons.PrimaryButton
import com.fabiocarballo.designsystem.components.buttons.SecondaryButton
import com.fabiocarballo.designsystem.components.buttons.TertiaryButton
import com.fabiocarballo.designsystem.components.buttons.TertiaryIconButton
import com.fabiocarballo.designsystem.components.buttons.internal.ButtonDefaults
import com.fabiocarballo.designsystem.components.headers.Header
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text

@Composable
fun ButtonsScreen(
    onBackClick: () -> Unit
) {

    val context = LocalContext.current
    val onClick = { Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show() }

    Column {
        Header(
            navigationIcon = {
                TertiaryIconButton(
                    onClick = onBackClick,
                    painter = painterResource(id = R.drawable.ic_arrow_left)
                )
            },
            title = { Text(text = "Buttons", style = Theme.typography.labelLarge) }
        )

        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            val modifier = Modifier.padding(
                horizontal = Theme.sizing.scale600,
                vertical = Theme.sizing.scale300
            )

            ButtonsSection(
                name = "Primary Buttons",
                modifier = modifier
            ) {
                PrimaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Large Primary Button")
                }

                PrimaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                ) {
                    Text(text = "Disabled Large Primary Button")
                }
            }

            ButtonsSection(
                name = "Secondary Buttons",
                modifier = modifier
            ) {
                SecondaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Medium Secondary Button")
                }

                SecondaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                ) {
                    Text(text = "Disabled Medium Secondary Button")
                }

                SecondaryButton(
                    onClick = onClick,
                    contentPadding = ButtonDefaults.smallButtonContentPadding(),
                    textStyle = ButtonDefaults.smallButtonTextStyle(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Small Secondary Button")
                }
            }

            ButtonsSection(
                name = "Tertiary Buttons",
                modifier = modifier
            ) {
                TertiaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Medium Tertiary Button")
                }

                TertiaryButton(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                ) {
                    Text(text = "Disabled Medium Tertiary Button")
                }

                TertiaryButton(
                    onClick = onClick,
                    contentPadding = ButtonDefaults.smallButtonContentPadding(),
                    textStyle = ButtonDefaults.smallButtonTextStyle(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Small Tertiary Button")
                }
            }
        }
    }
}

@Composable
private fun ButtonsSection(
    name: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Theme.sizing.scale300)
    ) {
        Text(
            text = name,
            style = Theme.typography.headingSmall,
            modifier = Modifier.padding(bottom = Theme.sizing.scale300)
        )

        content()
    }
}
