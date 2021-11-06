package com.fabiocarballo.designsystem.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.fabiocarballo.designsystem.foundation.Theme
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This class should be used whenever a screenshot test is implemented. This class provides a method
 * [runScreenshotTest] that renders a Composable content and records/verifies the validity of the screenshot.
 *
 * Internally, this runs on top of parameterized tests, so that each test runs in each of our brands and that we
 * can guarantee that there are no regressions for any brand.
 *
 * An example usage would be:
 *
 * ```kotlin
 * @Test
 * fun myTest() = runScreenshotTest {
 *   Text(
 *      text = "Hello"
 *   )
 * }
 * ```
 */
@RunWith(TestParameterInjector::class)
abstract class DesignSystemScreenshotTest : ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @TestParameter
    private lateinit var themeMode: ThemeMode

    fun runScreenshotTest(
        content: @Composable () -> Unit
    ) {

        composeTestRule.setContent {
            Theme(
                isSystemInDarkMode = themeMode == ThemeMode.DARK,
                content = content
            )
        }

        val name = "${extractClassAndMethodName()}_${themeMode.name.lowercase()}"

        compareScreenshot(
            rule = composeTestRule,
            name = name
        )
    }

    private enum class ThemeMode { LIGHT, DARK }
}

private fun extractClassAndMethodName(): String {
    val stack = Throwable().stackTrace

    stack.forEach { element ->
        try {
            val clazz = Class.forName(element.className)
            val method = clazz.getMethod(element.methodName)

            if (method.annotations.any { it.annotationClass == Test::class }) {
                return "${clazz.canonicalName}_${method.name}"
            }
        } catch (ignored: NoSuchMethodException) {
            // do nothing
        } catch (ignored: ClassNotFoundException) {
            // do nothing
        }
    }

    error("Couldn't parse the name")
}
