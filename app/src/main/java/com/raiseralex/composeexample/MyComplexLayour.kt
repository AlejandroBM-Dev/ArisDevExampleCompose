package com.raiseralex.composeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyComplexLayout(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier.weight(1f).background(Color.Red)) {}
        Box(modifier = Modifier.weight(1f).background(Color.Blue)) {
            Row {
                Box(modifier = Modifier.weight(1f).height(25.dp).background(Color.Gray)) {}
                Box(modifier = Modifier.weight(1f).height(75.dp).background(Color.Green)) {}
            }
        }
        Box(modifier = Modifier.weight(1f).background(Color.Yellow)) {}
    }
}

@Composable
fun RetoCompose(modifier: Modifier) {
    Column(modifier = modifier.background(Color.Gray)) {
        Box(
            modifier = Modifier.fillMaxSize().weight(1f).background(Color.Cyan),
            contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.weight(1f)) {
            Row {
                Box(
                    modifier = Modifier.fillMaxSize().weight(1f).background(Color.Red),
                    contentAlignment = Alignment.Center){
                    Text("Ejemplo 2")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier.fillMaxSize().weight(1f).background(Color.Green),
                    contentAlignment = Alignment.Center){
                    Text("Ejemplo 3")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.fillMaxSize().weight(1f).background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter) {
            Text("Ejemplo 4")
        }
    }
}

@Composable
fun BasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {

        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(
            modifier = Modifier.size(200.dp).background(Color.Red).constrainAs(boxRed) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            }
        ) {}

        Box(
            modifier = Modifier.size(200.dp).background(Color.Gray).constrainAs(boxGray) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            }
        ) {}

        Box(
            Modifier.size(200.dp).background(Color.Green).constrainAs(boxGreen) {
                bottom.linkTo(boxYellow.top)
                start.linkTo(boxYellow.end)
            }
        ) {}
        Box(
            Modifier.size(200.dp).background(Color.Magenta).constrainAs(boxMagenta) {
                bottom.linkTo(boxYellow.top)
                end.linkTo(boxYellow.start)
            }
        ) {}
        Box(
            Modifier.size(200.dp).background(Color.Yellow).constrainAs(boxYellow) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        ) {}

    }
}

@Composable
fun RetoComposableLayout(modifier: Modifier) {
    //75dp chicas - 175dp grandes
    ConstraintLayout(modifier = modifier) {
        val (boxCyan,boxRed,boxDarkGray,boxBlack,boxBlue, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()
        val barrier = createTopBarrier(
            boxCyan,
            boxRed,
            boxDarkGray,
            boxBlack,
            boxBlue,
            boxGray,
            boxGreen,
            boxMagenta,
            boxYellow
        )
        //TOP START
        Box(
            modifier = Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(boxBlack.start)
            }
        ) {}

        Box(
            modifier = Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack) {
                start.linkTo(boxCyan.end)
                end.linkTo(boxDarkGray.start)

                top.linkTo(boxCyan.top)
                bottom.linkTo(boxCyan.bottom)

            }
        ) {}

        Box(
            modifier = Modifier.size(175.dp).background(Color.DarkGray).constrainAs(boxDarkGray) {
                start.linkTo(boxBlack.end)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        ) {}
        //TOP END
        Box(
            modifier = Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta) {
                top.linkTo(boxCyan.bottom)
                end.linkTo(boxCyan.end)
            }
        ) {}

        Box(
            modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen) {
                top.linkTo(boxDarkGray.bottom)
                start.linkTo(boxDarkGray.start)
            }
        ) {}

        Box(
            modifier = Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow) {
                top.linkTo(boxMagenta.bottom)
                start.linkTo(boxMagenta.end)
                end.linkTo(boxGreen.start)
            }
        ) {}

        Box(
            modifier = Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {}

        Box(
            modifier = Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            }
        ) {}

        Box(
            modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            }
        ) {}



    }
}

@Composable
@Preview
fun PreviewComplexLayout() {
    //MyComplexLayout(modifier = Modifier.fillMaxSize())
    RetoCompose(modifier = Modifier.fillMaxSize())
}

@Composable
@Preview
fun PreviewConstraintComplexLayout() {
    //MyComplexLayout(modifier = Modifier.fillMaxSize())
    BasicConstraintLayout(modifier = Modifier.fillMaxSize())
}

@Composable
@Preview(
    device = Devices.PIXEL
)
fun PreviewRetoComposableLayout() {
    RetoComposableLayout(modifier = Modifier.fillMaxSize())
}