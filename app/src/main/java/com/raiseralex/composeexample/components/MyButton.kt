package com.raiseralex.composeexample.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MyButton(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                Log.d("HOLA","Printlll butonasdfads")
            },
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Yellow),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Gray
            )
        ) {
            Text("Button")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Gray,
                containerColor = Color.White,
            )
        ) {
            Text("Outlined")
        }

        Spacer(Modifier.width(10.dp))

        // Cosas menos importantes...
        TextButton(
            onClick = {}
        ) {
            Text("Cancel")
        }
        Spacer(Modifier.width(10.dp))

        // Cosas menos importantes...
        ElevatedButton (
            onClick = {},
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 20.dp,
                
            )
        ) {
            Text("Cancel")
        }
        Spacer(Modifier.width(10.dp))

        FilledTonalButton(
            onClick = {

            }
        ) {
            Text("FilledTonalButton")
        }
    }
}



@Composable
@Preview(
    showSystemUi = true
)
fun PreviewMyButton() {
    val modifier = Modifier.fillMaxSize().padding(35.dp)
    Column {
        MyButton(modifier)
    }
}
