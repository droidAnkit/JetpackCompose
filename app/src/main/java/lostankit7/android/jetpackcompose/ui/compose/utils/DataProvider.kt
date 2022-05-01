package lostankit7.android.jetpackcompose.ui.compose.utils

import lostankit7.android.jetpackcompose.R
import lostankit7.android.jetpackcompose.ui.compose.entity.BottomMenuContent
import lostankit7.android.jetpackcompose.ui.compose.entity.Feature
import lostankit7.android.jetpackcompose.ui.theme.*

val bottomMenuItems = listOf(
    BottomMenuContent("Home", R.drawable.ic_home),
    BottomMenuContent("Meditate", R.drawable.ic_bubble),
    BottomMenuContent("Sleep", R.drawable.ic_moon),
    BottomMenuContent("Music", R.drawable.ic_music),
    BottomMenuContent("Profile", R.drawable.ic_profile),
)

val featuresList = listOf(
    Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        title = "Calming sounds",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3
    )
)