package ua.ilyadreamix.common.core

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
private val darkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    tertiary = TertiaryDark
)
@Stable
private val lightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    tertiary = TertiaryLight
)

/** Default app theme for non-Android platforms */
@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when (useDarkTheme) {
        true -> darkColorScheme
        else -> lightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
