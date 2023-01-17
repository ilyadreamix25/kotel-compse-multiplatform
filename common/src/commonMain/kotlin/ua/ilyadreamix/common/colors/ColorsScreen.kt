package ua.ilyadreamix.common.colors

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import ua.ilyadreamix.common.utility.hexToString

open class DefaultColorInfo(
    open val name: String,
    open val color: Color,
    open val reverseColor: Color
)

data class OtherColorInfo(
    override val name: String,
    override val color: Color,
    override val reverseColor: Color,
    val span: Int = 1
) : DefaultColorInfo(name, color, reverseColor)

@Composable
fun ColorsScreen() {
    val clipBoardManager = LocalClipboardManager.current

    val commonColors = listOf(
        DefaultColorInfo("Primary", MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary),
        DefaultColorInfo("OnPrimary", MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.primary),
        DefaultColorInfo("PrimaryContainer",
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer),
        DefaultColorInfo("OnPrimaryContainer",
            MaterialTheme.colorScheme.onPrimaryContainer,
            MaterialTheme.colorScheme.primaryContainer),
        DefaultColorInfo("Secondary", MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.onSecondary),
        DefaultColorInfo("OnSecondary", MaterialTheme.colorScheme.onSecondary, MaterialTheme.colorScheme.secondary),
        DefaultColorInfo("SecondaryContainer",
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.onSecondaryContainer),
        DefaultColorInfo("OnSecondaryContainer",
            MaterialTheme.colorScheme.onSecondaryContainer,
            MaterialTheme.colorScheme.secondaryContainer),
        DefaultColorInfo("Tertiary", MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.onTertiary),
        DefaultColorInfo("OnTertiary", MaterialTheme.colorScheme.onTertiary, MaterialTheme.colorScheme.tertiary),
        DefaultColorInfo("TertiaryContainer",
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer),
        DefaultColorInfo("OnTertiaryContainer",
            MaterialTheme.colorScheme.onTertiaryContainer,
            MaterialTheme.colorScheme.tertiaryContainer),
        DefaultColorInfo("Surface", MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.onSurface),
        DefaultColorInfo("OnSurface", MaterialTheme.colorScheme.onSurface, MaterialTheme.colorScheme.surface),
        DefaultColorInfo("SurfaceVariant",
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.onSurfaceVariant),
        DefaultColorInfo("OnSurfaceVariant",
            MaterialTheme.colorScheme.onSurfaceVariant,
            MaterialTheme.colorScheme.surfaceVariant)
    )
    val otherColors = listOf(
        OtherColorInfo("Outline",
            MaterialTheme.colorScheme.outline,
            MaterialTheme.colorScheme.background,
            2
        ),
        OtherColorInfo("Background",
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.onBackground,
            1
        ),
        OtherColorInfo("OnBackground",
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.colorScheme.background,
            1
        ),
    )

    fun copyText(text: String) {
        clipBoardManager.setText(AnnotatedString(text))
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
    ) {
        items(
            commonColors,
            key = { it.hashCode() },
            span = { GridItemSpan(1) }
        ) { colorInfo ->
            ColorItem(colorInfo) { copyText(colorInfo.color.toArgb().hexToString()) }
        }

        items(
            otherColors.filter { it.span != 1 },
            key = { it.hashCode() },
            span = { GridItemSpan(2) }
        ) { colorInfo ->
            ColorItem(colorInfo) { copyText(colorInfo.color.toArgb().hexToString()) }
        }

        items(
            otherColors.filter { it.span == 1 },
            key = { it.hashCode() },
            span = { GridItemSpan(1) }
        ) { colorInfo ->
            ColorItem(colorInfo) { copyText(colorInfo.color.toArgb().hexToString()) }
        }
    }
}
