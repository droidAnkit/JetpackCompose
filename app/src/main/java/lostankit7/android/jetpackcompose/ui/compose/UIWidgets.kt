package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ShowWidget() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val textFieldState = remember {
        mutableStateOf("Hey there")
    }

    ShowWidget(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        textFieldState = textFieldState,
        scope = scope
    )

}

@Composable
fun ShowWidget(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    textFieldState: MutableState<String>,
    scope: CoroutineScope,
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Transparent, shape = RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier,
                    value = textFieldState.value,
                    label = {
                        Text(text = "Enter your name")
                    },
                    singleLine = true,
                    onValueChange = {
                        textFieldState.value = it
                    }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello ${textFieldState.value}")
                    }
                }) {
                    Text(text = "Tap")
                }
            }
        }
    }
}