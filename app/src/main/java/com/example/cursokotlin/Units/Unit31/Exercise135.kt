package com.example.cursokotlin.Units.Unit31

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project135(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    val dice = object {
        val array = IntArray(5)

        fun generate() {
            for (i in array.indices) {
                array[i] = ((Math.random() * 6) + 1).toInt()
            }
        }

        fun print(): String {
            return array.joinToString(" - ")
        }

        fun highest(): Int {
            return array.maxOrNull() ?: 0
        }
    }

    fun runDemo() {
        dice.generate()
        outputText = "Dice values: ${dice.print()}\n" +
                "Highest value: ${dice.highest()}"
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