package com.raiseralex.composeexample.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.raiseralex.composeexample.R

@Composable
fun MyImage(modifier: Modifier){

    Image(
        painter = painterResource(R.drawable.pay),
        contentDescription = "Image example...",
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 5.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color.Red,Color.Blue, Color.Yellow )
                ),
                shape = RoundedCornerShape(50)
            ),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        model = "https://es.wikipedia.org/wiki/Warhammer_40_000#/media/Archivo:Operation_Sci-Fi_Con_2015.jpg",
        modifier = modifier.size(300.dp),
        contentScale = ContentScale.Fit,
        contentDescription = "Image drom network",
        onError = {
            Log.i("CoilComponent", "Error ${it.result}")
        }
    )
}

@Composable
fun MyIcon(modifier: Modifier) {
    Icon(
        painter = painterResource(R.drawable.pay),
        contentDescription = "Icon Pay",
        modifier = modifier.size(400.dp),

    )
}

@Composable
@Preview(
    showSystemUi = true,
)
fun PreviewMyImage() {
    MyIcon(modifier = Modifier)
}