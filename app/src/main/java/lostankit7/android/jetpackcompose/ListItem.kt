package lostankit7.android.jetpackcompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ListItem(
    val title: String,
    var isSelected: MutableState<Boolean> = mutableStateOf(false),
)
