package com.raiseralex.composeexample.components

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        //1rst
        Text(
            text = "Alejandro", color = Color.Red
        )
        //2Second
        Text(
            text = "Alejandro", color = Color.Red, fontSize = 25.sp
        )
        //3rd
        Text(
            text = "Alejandro",
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            color = Color.Yellow,
            fontWeight = FontWeight.Bold
        )
        //4rt
        Text(
            text = "Letter Spacing",
            letterSpacing = 5.sp,
            fontSize = 40.sp,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "TextDecoration",
            fontSize = 50.sp,
            color = Color.Blue,
            textDecoration = TextDecoration.LineThrough
        )

        Text(
            text = "TextDecoration",
            fontSize = 50.sp,
            color = Color.Blue,
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            )
        )

        Text(
            text = "TextDecoration",
            fontSize = 20.sp,
            color = Color.Green,
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "TextDecoration TextDecoration TextDecoration TextDecoration TextDecoration TextDecoration TextDecoration",
            fontSize = 20.sp,
            color = Color.Magenta,
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            ),
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            overflow = TextOverflow.Ellipsis
        )

    }

}

@Composable
@Preview
fun PreviewMyTexts() {
    MyTexts(modifier = Modifier.fillMaxSize())
}