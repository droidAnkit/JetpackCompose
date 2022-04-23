package lostankit7.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lostankit7.android.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.4f)
                    //.offset(10.dp, 20.dp)
                    .border(5.dp, color = Color.Black)
                    .padding(5.dp)
                    .border(3.dp, Color.Yellow)
                    .padding(3.dp)
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.SpaceEvenly,
//                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "It's", color = Color.Red,
                    modifier = Modifier
                        .padding(3.dp)
                        .background(Color.Yellow)
                        .fillMaxWidth(.25f)
                        .fillMaxHeight(.25f)
                        .padding(1.dp)
                        .align(Alignment.CenterVertically)
                        .border(2.dp, Color.DarkGray),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                )
                Text(text = "actually", color = Color.Red)
                Text(text = "nice", color = Color.White)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Greeting("Android")
    }
}