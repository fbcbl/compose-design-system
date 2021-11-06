package com.fabiocarballo.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.fabiocarballo.designsystem.foundation.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                Column {
                    Greeting("Android", style = Theme.typography.display)
                    Greeting("Android", style = Theme.typography.heading)
                    Greeting("Android", style = Theme.typography.paragraph)
                    Greeting("Android", style = Theme.typography.label)
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
