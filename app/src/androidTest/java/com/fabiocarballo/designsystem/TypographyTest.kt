package com.fabiocarballo.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.fabiocarballo.designsystem.foundation.Theme
import com.fabiocarballo.designsystem.foundation.text.Text
import com.fabiocarballo.designsystem.internal.DesignSystemScreenshotTest

import org.junit.Test

class TypographyTest : DesignSystemScreenshotTest() {

    @Test
    fun display() = runScreenshotTest {
        TestDummy(text = "This is a display.", style = Theme.typography.displayLarge)
    }

    @Test
    fun paragraph() = runScreenshotTest {
        TestDummy(text = "This is a paragraph.", style = Theme.typography.paragraphLarge)
    }

    @Test
    fun label() = runScreenshotTest {
        TestDummy(text = "This is a label.", style = Theme.typography.labelMedium)
    }

    @Composable
    private fun TestDummy(
        text: String,
        style: TextStyle
    ) {
        Box(
            Modifier
                .background(Theme.colors.backgroundPrimary)
                .padding(16.dp)
        ) {
            Text(text = text, style = style)
        }
    }
}
