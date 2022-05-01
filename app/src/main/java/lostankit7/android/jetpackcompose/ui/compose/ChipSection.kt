package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import lostankit7.android.jetpackcompose.ui.theme.ButtonBlue
import lostankit7.android.jetpackcompose.ui.theme.DarkerButtonBlue
import lostankit7.android.jetpackcompose.ui.theme.TextWhite

@Composable
fun ChipSection(
    chips: List<String>,
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) { currentIndex ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {

                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedChipIndex == currentIndex) ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp)
            ) {
                Text(text = chips[currentIndex], color = TextWhite)
            }
        }
    }
}