package com.example.cursokotlin.Units.Unit31

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

object Mathematics {
    const val PI = 3.1416
    fun random(minimum: Int, maximum: Int) = ((Math.random() * (maximum + 1 - minimum)) + minimum).toInt()
}

@Composable
fun Project134(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        outputText = "The value of Pi is ${Mathematics.PI}\n" +
                "A random value between 5 and 10: ${Mathematics.random(5, 10)}"
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Run Mathematics Demo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}