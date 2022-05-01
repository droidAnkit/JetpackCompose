package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lostankit7.android.jetpackcompose.R
import lostankit7.android.jetpackcompose.ui.theme.BlueViolet1
import lostankit7.android.jetpackcompose.ui.theme.TextWhite

@Composable
fun GreetingSection(
    name: String = "Ankit",
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        HeadBodyVerticalTexts(headerText = "Good morning, $name",
            bodyText = "We wish you have a good day!",
            bodyColor = BlueViolet1)
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun HeadBodyVerticalTexts(
    headerText: String,
    bodyText: String,
    bodyColor: Color,
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = headerText, style = MaterialTheme.typography.h5, color = TextWhite
        )
        Text(
            text = bodyText, style = MaterialTheme.typography.body2, color = bodyColor
        )
    }
}