package com.fabiocarballo.taxi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.taxi.onboarding.WelcomeScreen
import com.fabiocarballo.taxi.trips.presentation.Trips

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                var screen by remember { mutableStateOf(Screen.WELCOME) }

                when (screen) {
                    Screen.WELCOME -> WelcomeScreen(
                        onStartClick = { screen = Screen.TRIPS })
                    Screen.TRIPS -> Trips()
                }
            }
        }
    }
}

private enum class Screen {
    WELCOME,
    TRIPS
}
