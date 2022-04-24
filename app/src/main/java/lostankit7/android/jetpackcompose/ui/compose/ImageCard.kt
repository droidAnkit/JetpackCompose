package lostankit7.android.jetpackcompose.ui.compose

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lostankit7.android.jetpackcompose.ui.utils.showToast

@ExperimentalMaterialApi
@SuppressLint("ModifierParameter")
@Composable
fun Activity.ImageCard(
    modifier: Modifier = Modifier
        .fillMaxWidth(0.4f)
        .height(160.dp),
    painter: Painter,
    title: String,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
        onClick = {
            showToast("You tapped on compose card")
        }
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painter,
                contentDescription = title
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 370f
                    )
                )
            )
            Text(
                text = title,
                style = TextStyle(Color.White, 12.sp),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}