package ua.ilyadreamix.common.strings

import androidx.compose.ui.text.intl.Locale

fun Locale.toStrings() = when (this.language) {
    else -> ENStrings
}
