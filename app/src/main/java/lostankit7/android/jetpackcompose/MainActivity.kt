package lostankit7.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import lostankit7.android.jetpackcompose.ui.compose.*
import lostankit7.android.jetpackcompose.ui.theme.JetpackComposeTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeOfBox by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeOfBox,
                tween(1000)
//                spring(),
            )

            val infiniteTransaction = rememberInfiniteTransition()
            val color by infiniteTransaction.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(2000),
                    RepeatMode.Reverse
                )
            )

            Box(modifier = Modifier
                .size(size)
                .background(color),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    sizeOfBox += 50.dp
                }) {

                }
            }
        }
    }
}