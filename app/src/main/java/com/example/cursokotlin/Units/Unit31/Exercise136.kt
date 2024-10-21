package com.example.cursokotlin.Units.Unit31

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

object Maximum {
    fun max(x1: Int, x2: Int) = if (x1 > x2) x1 else x2
    fun max(x1: Float, x2: Float) = if (x1 > x2) x1 else x2
    fun max(x1: Double, x2: Double) = if (x1 > x2) x1 else x2
}

@Composable
fun Project136(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        outputText = "Max of 4 and 5: ${Maximum.max(4, 5)}\n" +
                "Max of 10.2f and 23.5f: ${Maximum.max(10.2f, 23.5f)}\n" +
                "Max of 4.5 and 5.2: ${Maximum.max(4.5, 5.2)}"
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Run Maximum Demo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}