package lostankit7.android.jetpackcompose

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import lostankit7.android.jetpackcompose.ui.theme.JetpackComposeTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val moonScrollSpeed = 0.08f
                val midBgScrollSpeed = 0.03f

                val imageHeight = (LocalConfiguration.current.screenWidthDp * (2f / 3f)).dp
                val lazyListState = rememberLazyListState()

                var moonOffSet by remember {
                    mutableStateOf(0f)
                }
                var midBgOffSet by remember {
                    mutableStateOf(0f)
                }

                val nestedScrollConnection = remember {
                    object : NestedScrollConnection {
                        override fun onPreScroll(
                            available: Offset,
                            source: NestedScrollSource,
                        ): Offset {
                            val delta = available.y

                            if (lazyListState.firstVisibleItemIndex == 0 ||
                                lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == lazyListState.layoutInfo.totalItemsCount - 1
                            ) {
                                return Offset.Zero
                            }

                            moonOffSet += delta * moonScrollSpeed
                            midBgOffSet += delta * midBgOffSet
                            return Offset.Zero
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .nestedScroll(nestedScrollConnection),
                    state = lazyListState
                ) {
                    items(10) {
                        Text(text = "Sample Item",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp))
                    }

                    item {
                        Box(modifier = Modifier
                            .clipToBounds()
                            .fillMaxWidth()
                            .height(imageHeight + midBgOffSet.toDp())
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color(0xFFf36b21), Color(0xFFf9a521))
                                )
                            )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_moonbg),
                                contentDescription = "moon",
                                contentScale = ContentScale.FillWidth,
                                alignment = BottomCenter,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .graphicsLayer {
                                        translationY = moonOffSet
                                    }
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_midbg),
                                contentDescription = "mid bg",
                                contentScale = ContentScale.FillWidth,
                                alignment = BottomCenter,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .graphicsLayer {
                                        translationY = midBgOffSet
                                    }
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_outerbg),
                                contentDescription = "outer bg",
                                contentScale = ContentScale.FillWidth,
                                alignment = BottomCenter,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    items(20) {
                        Text(text = "Sample Item",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp))
                    }
                }
            }
        }
    }

    private fun Float.toDp() =
        (this / Resources.getSystem().displayMetrics.density).dp
}