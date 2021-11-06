package com.fabiocarballo.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.components.Button
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            Theme(
                isSystemInDarkMode = isDarkMode
            ) {
                Column(
                    Modifier
                        .background(Theme.colors.backgroundPrimary)
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Greeting("Android", style = Theme.typography.display)
                    Greeting("Android", style = Theme.typography.heading)
                    Greeting("Android", style = Theme.typography.paragraph)
                    Greeting("Android", style = Theme.typography.label)

                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { isDarkMode = !isDarkMode }
                    ) {
                        Text(text = "Toggle UI mode")
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = "Hello $name!",
        style = style
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Theme {
        Greeting("Androiders")
    }
}
