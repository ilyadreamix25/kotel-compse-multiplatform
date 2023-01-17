import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ua.ilyadreamix.common.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(position = WindowPosition(Alignment.Center)),
        transparent = true,
        undecorated = true
    ) {
        App()
    }
}
