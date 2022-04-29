package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ConstraintLayout

private const val UPPER_BOX_ID = "upper_box"
private const val LOWER_BOX_ID = "lower_box"

@Composable
fun ApplyConstraintLayout() {
    val constraints = ConstraintSet {
        val upperBox = createRefFor(UPPER_BOX_ID)
        val lowerBox = createRefFor(LOWER_BOX_ID)

        constrain(upperBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(80.dp)
        }

        constrain(lowerBox) {
            top.linkTo(parent.top)
            start.linkTo(upperBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(80.dp)
        }
        createHorizontalChain(upperBox,lowerBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(constraints, modifier = Modifier
        .fillMaxSize()
    ) {

        Text(modifier = Modifier
            .background(Color.LightGray)
            .layoutId(UPPER_BOX_ID),
            text = "Hi testing the above box",
        )

        Text(modifier = Modifier
            .background(Color.Green)
            .layoutId(LOWER_BOX_ID),
            text = "Hi test the below box",
            textAlign = TextAlign.Center
        )
    }
}