package lostankit7.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import lostankit7.android.jetpackcompose.ui.compose.*
import lostankit7.android.jetpackcompose.ui.theme.JetpackComposeTheme

/*
* Side effects are something which escapes the scope of a composable function
*/

/*
* Avoid using non compose in composable function
*/


@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun DerivedStateDemo() {
    var counter by remember {
        mutableStateOf(0)
    }

    //everytime we access counterText , whole string is recomputed,
    // `The counter is` + counter , concatenation occurs everytime
    val counterText = "The counter is $counter"

    //to solve above issue , we use derivedStateOf
    //it cache the computation locally and uses it
    val counterTextCorrect by derivedStateOf {
        "The counter is $counter"
    }

    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}

@Composable
fun produceStateDemo(): State<Int> {
    /*return produceState(initialValue = 0, producer = {
        while (value < 10) {
            delay(100)
            value ++
        }
    })*/

    //above code as flow
    return flow<Int> {
        var value = 0
        while (value < 10) {
            emit(value)
            value++
        }
    }.collectAsState(initial = 0)
}

@Composable
fun SideEffectDemo() {
    //side effect block is called everytime view is recomposed
    SideEffect {

    }
}

@Composable
fun DisposableEffectDemo() {
    // use disposable effect when we have something to be disposed inside compose
    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifeCycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                // do something
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun `RememberCoroutine-Scope`() {
    //if we don't rememberCoroutineScope then when the button leaves the composition
    // the coroutine is cancelled
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            //do some network call
        }
    }) {

    }
}

@Composable
fun SideEffectHandler() {
    var text by remember {
        mutableStateOf("")
    }
    JetpackComposeTheme {
        /*Button(onClick = { text += "#" }) {
            //whenever button is clicked and is recomposed
            i++
            Text(text = text)
        }*/

        /* whenever text is changed, below coroutine scope is cancelled and relaunched */
        LaunchedEffect(key1 = text) {

        }
    }
}