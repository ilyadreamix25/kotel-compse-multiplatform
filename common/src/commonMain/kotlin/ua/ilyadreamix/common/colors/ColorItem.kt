package ua.ilyadreamix.common.colors

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorItem(
    colorInfo: DefaultColorInfo,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .height(120.dp)
            .clickable { onClick() }
            .background(colorInfo.color)
            .padding(12.dp)
    ) {
        Text(
            text = colorInfo.name,
            style = LocalTextStyle.current.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = .25f),
                    offset = Offset(0f, 0f),
                    blurRadius = 5f
                ),
                color = colorInfo.reverseColor,
                fontSize = 15.sp
            )
        )
    }
}
