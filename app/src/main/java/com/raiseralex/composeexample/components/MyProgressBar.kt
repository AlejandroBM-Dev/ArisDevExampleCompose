package com.raiseralex.composeexample.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.raiseralex.composeexample.R

@Composable
fun MyProgressBar(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(70.dp),
            color = Color.Red,
            strokeWidth = 15.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Butt
        )
        Spacer(Modifier.height(20.dp))
        LinearProgressIndicator(
            color = Color.Blue,
            trackColor = Color.Cyan,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.height(20.dp))

    }
}

@Composable
fun MyProgressBarAdvanced(modifier: Modifier) {
    var progress: Float by remember { mutableFloatStateOf(0.0f) }
    val animateProgress by animateFloatAsState(targetValue = progress)
    var isLoading: Boolean by remember { mutableStateOf(true) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(70.dp),
            color = Color.Red,
            strokeWidth = 15.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Butt
        )
        Spacer(Modifier.height(20.dp))

        if (isLoading) {
            CircularProgressIndicator(
                progress = {
                    animateProgress
                },
                modifier = Modifier.size(70.dp),
                color = Color.Red,
                strokeWidth = 15.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Butt
            )
        } else {
            Text("NO SE ESTA CARGANDO NADA :(")
        }

        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (progress >= 0.0f) progress -= 0.1f
                }
            ) {
                Text("<-")
            }
            Spacer(Modifier.width(30.dp))
            Button(
                onClick = {
                    if (progress <= 1.0f) progress += 0.1f

                }
            ) {
                Text("->")
            }
        }
        Button(
            onClick = {
                isLoading = !isLoading

            }
        ) {
            Text("Show bar")
        }

        Spacer(Modifier.height(20.dp))
        LinearProgressIndicator(
            color = Color.Blue,
            trackColor = Color.Cyan,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.height(20.dp))

    }
}

@Composable
fun MyLottieAnimationProgress(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.aristdev_loading_lottie))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            restartOnPlay = true
        )
    }
}

@Composable
@Preview
fun PreviewMyProgressBar() {
    MyLottieAnimationProgress(modifier = Modifier)
}