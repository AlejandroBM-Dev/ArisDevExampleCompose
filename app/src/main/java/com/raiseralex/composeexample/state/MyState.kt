package com.raiseralex.composeexample.state

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//Estados en jetpackCompose
@Composable
fun MyState(modifier: Modifier) {
    //var number :String = "0"
    var number = remember { mutableStateOf(0) }
    TextButton(
        content = { Text("Click me ${number.value}")},
        onClick = { number.value += 1},
        modifier = modifier
    )
}
//Para cuando se nos ocurre girar la pantalla
@Composable
fun MyStateSaveable(modifier: Modifier) {
    //var number :String = "0"
    // Operador by.. nos permite acceder directo al valor
    // by -> StatePorperty
    var number by rememberSaveable { mutableIntStateOf(0) }
    TextButton(
        content = { Text("Click me $number")},
        onClick = { number += 1},
        modifier = modifier
    )
}

@Composable
@Preview
fun PreviewMyState() {
    MyStateSaveable(modifier = Modifier)
}