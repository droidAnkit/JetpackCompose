package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun State() {
    val color = remember { mutableStateOf(Color.Yellow) }
    Column(Modifier.fillMaxSize()) {
        ColorGeneratorBox(
            modifier = Modifier.weight(1f)
        ) {
            color.value = it
        }
        ColorBox(modifier = Modifier
            .weight(1f),
            color = color
        )
    }
}

@Composable
fun ColorGeneratorBox(
    modifier: Modifier = Modifier,
    generateColor: (Color) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                generateColor.invoke(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    color: State<Color>,
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(color.value)
    )
}