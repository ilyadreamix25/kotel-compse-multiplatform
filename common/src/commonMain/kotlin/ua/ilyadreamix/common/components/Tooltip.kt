package ua.ilyadreamix.common.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WithTooltip(
    text: String,
    content: @Composable () -> Unit = {}
) {
    TooltipArea(
        tooltip = {
            ElevatedCard(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(Color.White, Color.Black),
                elevation = CardDefaults.elevatedCardElevation(5.dp)
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(10.dp)
                )
            }
        },
        content = content
    )
}
