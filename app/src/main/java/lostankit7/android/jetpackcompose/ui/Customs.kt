package lostankit7.android.jetpackcompose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
)

data class Colors(
    val light: Color = Color(0xFFF2F3E3),
    val medium: Color = Color.Yellow,
    val dark: Color = Color.Red,
)

val LocalSpacing = compositionLocalOf { Spacing() }
val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.customColors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
