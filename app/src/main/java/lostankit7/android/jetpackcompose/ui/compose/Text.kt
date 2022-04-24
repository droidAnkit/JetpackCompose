package lostankit7.android.jetpackcompose.ui.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextStyling() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 40.sp,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("C")
            }
            append("ompose looks good  ")
            withStyle(
                style = SpanStyle(
                    color = Color.DarkGray,
                    textDecoration = TextDecoration.LineThrough,
                    fontFamily = FontFamily.SansSerif
                )
            ) {
                append("xml deprecated")
            }
        },
        color = Color.Black,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive
    )
}