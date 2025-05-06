package com.raiseralex.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.raiseralex.composeexample.components.MyConfirmationDialog
import com.raiseralex.composeexample.components.MyNetworkImage
import com.raiseralex.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var status by remember { mutableStateOf("") }
                    var show by remember { mutableStateOf(false) }

                    // MyNetworkImage(modifier = Modifier.fillMaxSize())
                    // MyProgressBarAdvanced(modifier = Modifier)

                    Button(
                        onClick = { show = !show }
                    ) {
                        Text("SHOW DIALOG")
                    }
                    MyConfirmationDialog( show ) {
                        show = false
                    }
                }
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Suppress("ktlint:standard:function-naming")
@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    ComposeExampleTheme {
        MyNetworkImage(modifier = Modifier.fillMaxSize())
    }
}
