@file:Suppress("ktlint:standard:filename")

package com.raiseralex.composeexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Suppress("ktlint:standard:function-naming")
@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = {
                onDismiss()
            },
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().background(Color.White),
            ) {
                Text(
                    text = "Phone ringtone",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                )
                HorizontalDivider(modifier = Modifier.width(2.dp), color = Color.LightGray)
                MyRa
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
@Preview(
    showSystemUi = true,
)
fun MyConfirmation() {
    MyConfirmationDialog(
        true,
    ) {

    }
}
