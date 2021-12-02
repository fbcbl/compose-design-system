package com.fabiocarballo.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.components.buttons.TertiaryIconButton
import com.fabiocarballo.designsystem.components.headers.Header
import com.fabiocarballo.designsystem.components.list.item.CompactListItem
import com.fabiocarballo.designsystem.components.list.item.ListItemTitle
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text
import com.fabiocarballo.designsystem.screens.ButtonsScreen
import com.fabiocarballo.designsystem.screens.CardsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            var screen: Screen by remember { mutableStateOf(Screen.HOME) }
            val shouldHandleBack by remember(screen) { derivedStateOf { screen != Screen.HOME } }

            val goToHome = { screen = Screen.HOME }

            BackHandler(
                enabled = shouldHandleBack,
                onBack = goToHome
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
                        Screen.BUTTONS -> ButtonsScreen(onBackClick = goToHome)
                        Screen.CARDS -> CardsScreen(onBackClick = goToHome)
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
            .padding(vertical = Theme.sizing.scale300)
    ) {
        Header(
            title = { Text(text = "Glossary") },
            actions = {
                TertiaryIconButton(
                    onClick = onToggleUiClick,
                    painter = painterResource(id = R.drawable.ic_sun_moon)
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Screen.values()
            .filter { it != Screen.HOME }
            .forEach { screen ->
                CompactListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onScreenSelected(screen) }
                ) {
                    ListItemTitle(label = screen.label)
                }
            }
    }
}
