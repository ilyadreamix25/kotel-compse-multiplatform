import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ua.ilyadreamix.common.main.MainAppScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(
            position = WindowPosition(Alignment.Center),
            width = 900.dp,
            height = 724.dp
        ),
        transparent = true,
        undecorated = true,
        resizable = false
    ) { MainAppScreen() }
}
