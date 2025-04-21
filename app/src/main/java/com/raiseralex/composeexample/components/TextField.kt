package com.raiseralex.composeexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices.PIXEL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier){
    var text by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        MyTextField(
            text
        ) { textChange ->
            text = textChange
        }
        MySecondTextField( value ) {
            value = it
        }
        MyPasswordTF(value) {
            value = it
        }
        MyOutlineTF(value) {
            value = it
        }
        //MyLoginButton()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(user: String,userChange:( String ) -> Unit) {

        TextField(
            value = user,
            onValueChange = { userChange(it)}
        )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySecondTextField(value: String,onValueChange:(String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {onValueChange(it)},
        placeholder = {
            Box(modifier = Modifier.width(30.dp).height(30.dp).background(color = Color.Red))
        },
        /*label = {
            Text("Alex")
        }*/
    )
}

@Composable
fun MyPasswordTF(value:String, onValueChange:(String) -> Unit) {
    var showPass by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = {onValueChange(it)},
        singleLine = true,
        label = {
            Text("Ingresa tú contraseña")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (showPass) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            TextButton(
                onClick = {
                    showPass = !showPass
                }
            ) {
                Text(
                    text = if (showPass) {"Mostrar"} else {"Ocultar"},
                )
            }
        }
    )
}

@Composable
fun MyOutlineTF(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) }
    )

    Spacer(modifier = Modifier.height(10.dp))

    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it)}
    )
}

@Composable
@Preview(
    device = PIXEL,
    showSystemUi = true
)
fun PreviewMyTextField() {
    MyTextFieldParent(Modifier.fillMaxSize())
}