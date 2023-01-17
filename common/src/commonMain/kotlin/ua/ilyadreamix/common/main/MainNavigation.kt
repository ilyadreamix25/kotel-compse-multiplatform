package ua.ilyadreamix.common.main

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.ForkLeft
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import ua.ilyadreamix.common.colors.ColorsScreen
import ua.ilyadreamix.common.strings.toStrings

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(selectedNavItem: MainNavigationDrawerItem) {
    AnimatedContent(
        selectedNavItem,
        modifier = Modifier.padding(16.dp)
    ) { screen ->
        when (screen) {
            else -> ColorsScreen()
        }
    }
}

sealed class MainNavigationDrawerItem(
    val label: String,
    val icon: ImageVector
) {
    object Buttons : MainNavigationDrawerItem(
        label = strings.buttons,
        icon = Icons.Filled.AdsClick
    )
    object Navigation : MainNavigationDrawerItem(
        label = strings.navigation,
        icon = Icons.Filled.ForkLeft
    )
    object Colors : MainNavigationDrawerItem(
        label = strings.colors,
        icon = Icons.Filled.Palette
    )
    object TextFields : MainNavigationDrawerItem(
        label = strings.textFields,
        icon = Icons.Filled.TextFields
    )

    companion object {
        protected val strings = Locale.current.toStrings()

        fun asList() = listOf(
            Colors,
            Buttons,
            Navigation,
            TextFields
        )
    }
}
