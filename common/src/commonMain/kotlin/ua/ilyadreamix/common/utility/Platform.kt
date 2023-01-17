package ua.ilyadreamix.common.utility

import androidx.compose.runtime.Composable
import ua.ilyadreamix.common.getPlatform

enum class Platform {
    DESKTOP,
    ANDROID
}

@Composable
fun IfPlatform(platform: Platform, then: @Composable () -> Unit = {}) =
    if (getPlatform() == platform) then()
    else Unit

@Composable
fun IfDesktop(then: @Composable () -> Unit = {}) = IfPlatform(Platform.DESKTOP, then)

@Composable
fun IfAndroid(then: @Composable () -> Unit = {}) = IfPlatform(Platform.ANDROID, then)
