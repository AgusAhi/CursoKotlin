package com.example.cursokotlin.Units.Unit29

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Die(var value: Int) {
    override fun toString(): String {
        return "*".repeat(value)
    }
}

@Composable
fun Project130(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        val die1 = Die(4)
        val die2 = Die(6)
        val die3 = Die(1)
        outputText = "${die1}\n${die2}\n${die3}"
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Roll Dice")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}