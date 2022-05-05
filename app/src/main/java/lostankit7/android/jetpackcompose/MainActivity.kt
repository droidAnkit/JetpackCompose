package lostankit7.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import lostankit7.android.jetpackcompose.ui.LocalSpacing
import lostankit7.android.jetpackcompose.ui.customColors

//url : https://www.youtube.com/watch?v=TOflUdgx4pw&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=13

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val customSmall = LocalSpacing.current.extraLarge
            Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
                Text(
                    modifier = Modifier
                        .size(customSmall)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "ji",
                    color = MaterialTheme.customColors.dark
                )
            }
        }
    }
}