package com.fabiocarballo.designsystem.components.list.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fabiocarballo.designsystem.components.dividers.Divider
import com.fabiocarballo.designsystem.foundation.Theme

@Composable
internal fun CoreListItem(
    main: @Composable () -> Unit,
    end: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = Theme.sizing.scale300),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProvideTextStyle(Theme.typography.labelMedium) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                main()
            }
        }

        if (end != null) {
            end()
        }
    }
}

@Composable
fun CompactListItem(
    modifier: Modifier = Modifier,
    main: @Composable () -> Unit,
) {
    Column(modifier) {
        CoreListItem(
            main = main,
            modifier = modifier.padding(vertical = Theme.sizing.scale500)
        )

        Divider()
    }
}

@Composable
fun StandardListItem(
    modifier: Modifier = Modifier,
    main: @Composable () -> Unit,
    end: @Composable (() -> Unit)? = null
) {
    Column(modifier) {
        CoreListItem(
            main = main,
            end = end,
            modifier = modifier.padding(vertical = Theme.sizing.scale600)
        )

        Divider()
    }
}

@Composable
fun ListItemTitle(
    label: String,
    paragraph: String? = null
) {
    Column {
        Text(
            text = label
        )

        paragraph?.let {
            Text(
                text = paragraph,
                style = Theme.typography.paragraphSmall,
                color = Theme.colors.contentSecondary
            )
        }
    }
}
