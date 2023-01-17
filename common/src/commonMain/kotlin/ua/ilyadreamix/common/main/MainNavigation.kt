package ua.ilyadreamix.common.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.ForkLeft
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.intl.Locale
import ua.ilyadreamix.common.strings.toStrings

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
            MainNavigationDrawerItem.Colors,
            MainNavigationDrawerItem.Buttons,
            MainNavigationDrawerItem.Navigation,
            MainNavigationDrawerItem.TextFields
        )
    }
}
