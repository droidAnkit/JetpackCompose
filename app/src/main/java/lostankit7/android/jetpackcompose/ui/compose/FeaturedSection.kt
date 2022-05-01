package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lostankit7.android.jetpackcompose.R
import lostankit7.android.jetpackcompose.ui.compose.entity.Feature
import lostankit7.android.jetpackcompose.ui.compose.utils.standardQuadFromTo
import lostankit7.android.jetpackcompose.ui.theme.TextWhite

@ExperimentalFoundationApi
@Composable
fun FeaturedSection(
    features: List<Feature>,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            color = TextWhite,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeaturedItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeaturedItem(
    feature: Feature,
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //medium colored path
        val mediumColoredPoints = listOf(
            Offset(width * 0f, height * 0.3f),
            Offset(width * 0.1f, height * 0.35f),
            Offset(width * 0.4f, height * 0.05f),
            Offset(width * 0.75f, height * 0.7f),
            Offset(width * 1.4f, -height.toFloat()),
        )

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoints[0].x, mediumColoredPoints[0].y)
            for (i in 1 until mediumColoredPoints.size) {
                standardQuadFromTo(mediumColoredPoints[i - 1], mediumColoredPoints[i])
            }
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        //light colored path
        val lightColoredPoints = listOf(
            Offset(width * 0f, height * 0.35f),
            Offset(width * 0.1f, height * 0.4f),
            Offset(width * 0.3f, height * 0.35f),
            Offset(width * 0.65f, height.toFloat()),
            Offset(width * 1.4f, -height.toFloat() / 3f),
        )

        val lightColoredPath = Path().apply {
            moveTo(lightColoredPoints[0].x, lightColoredPoints[0].y)
            for (i in 1 until lightColoredPoints.size) {
                standardQuadFromTo(lightColoredPoints[i - 1], lightColoredPoints[i])
            }
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path = mediumColoredPath, color = feature.mediumColor)
            drawPath(path = lightColoredPath, color = feature.lightColor)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                color = TextWhite,
                style = MaterialTheme.typography.h5,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .padding(vertical = 6.dp, horizontal = 50.dp)
            )
        }
    }
}