package com.fabiocarballo.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.components.buttons.PrimaryButton
import com.fabiocarballo.designsystem.components.buttons.SecondaryButton
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text
import com.fabiocarballo.designsystem.screens.ButtonsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            var screen: Screen by remember { mutableStateOf(Screen.HOME) }
            val shouldHandleBack by remember(screen) { derivedStateOf { screen != Screen.HOME } }

            BackHandler(
                enabled = shouldHandleBack,
                onBack = { screen = Screen.HOME }
            )

            Theme(
                isSystemInDarkMode = isDarkMode
            ) {
                Box(
                    modifier = Modifier
                        .background(Theme.colors.backgroundPrimary)
                        .fillMaxSize()
                ) {
                    when (screen) {
                        Screen.HOME -> {
                            HomeScreen(
                                onToggleUiClick = { isDarkMode = !isDarkMode },
                                onScreenSelected = { screen = it }
                            )
                        }
                        Screen.BUTTONS -> {
                            ButtonsScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    onScreenSelected: (Screen) -> Unit,
    onToggleUiClick: () -> Unit
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Glossary", style = Theme.typography.displayMedium)

        Spacer(modifier = Modifier.height(8.dp))

        SecondaryButton(
            onClick = { onScreenSelected(Screen.BUTTONS) }
        ) {
            Text(text = "Buttons")
        }

        Spacer(modifier = Modifier.weight(1f))


        PrimaryButton(onClick = onToggleUiClick) {
            Text(text = "Toggle UI mode")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Theme {
        Text("Androiders")
    }
}
