package com.fabiocarballo.taxi.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.components.buttons.PrimaryButton
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.LocalContentColor
import com.fabiocarballo.designsystem.foundation.text.Text
import com.fabiocarballo.taxi.R

@Composable
fun WelcomeScreen(
    onStartClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Theme.colors.backgroundAccent)
            .fillMaxSize()
            .padding(Theme.sizing.scale600),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CompositionLocalProvider(
            LocalContentColor provides Theme.colors.contentOnColor
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = Theme.typography.displayXSmall,
                modifier = Modifier.padding(vertical = Theme.sizing.scale600)
            )

            Image(
                painter = painterResource(id = R.drawable.illu_taxi),
                contentDescription = null,
                modifier = Modifier.size(240.dp)
            )

            Text(
                text = stringResource(id = R.string.welcome_placeholder_move_safely),
                style = Theme.typography.headingLarge
            )



            Spacer(Modifier.weight(1f))

            PrimaryButton(
                onClick = onStartClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.welcome_action_start))
            }
        }
    }
}
