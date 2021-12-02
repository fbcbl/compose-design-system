package com.fabiocarballo.designsystem.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.fabiocarballo.designsystem.R
import com.fabiocarballo.designsystem.components.buttons.SecondaryButton
import com.fabiocarballo.designsystem.components.buttons.TertiaryIconButton
import com.fabiocarballo.designsystem.components.cards.Card
import com.fabiocarballo.designsystem.components.headers.Header
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text

@Composable
fun CardsScreen(
    onBackClick: () -> Unit
) {

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

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier.padding(
                    horizontal = Theme.sizing.scale300,
                    vertical = Theme.sizing.scale600
                ),
            ) {
                Text(text = "Cards", style = Theme.typography.headingXSmall)
                Spacer(modifier = Modifier.height(Theme.sizing.scale300))
                Text(text = "Check examples of how cards can be used.")
                Spacer(modifier = Modifier.height(Theme.sizing.scale300))

                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Learn more")
                }
            }
        }
    }
}
