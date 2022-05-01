package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import lostankit7.android.jetpackcompose.R
import lostankit7.android.jetpackcompose.ui.compose.entity.BottomMenuContent
import lostankit7.android.jetpackcompose.ui.compose.entity.Feature
import lostankit7.android.jetpackcompose.ui.compose.utils.bottomMenuItems
import lostankit7.android.jetpackcompose.ui.compose.utils.featuresList
import lostankit7.android.jetpackcompose.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Meditation", "Depression"))
            CurrentMeditation()
            FeaturedSection(features = featuresList)
        }
        BottomMenu(items = bottomMenuItems, modifier = Modifier.align(Alignment.BottomCenter))
    }
}
