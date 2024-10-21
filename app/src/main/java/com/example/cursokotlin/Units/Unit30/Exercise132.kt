package com.example.cursokotlin.Units.Unit30

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

enum class OperationType(val symbol: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/")
}

class Operation(val value1: Int, val value2: Int, val operationType: OperationType) {
    fun perform(): String {
        val result = when (operationType) {
            OperationType.ADDITION -> value1 + value2
            OperationType.SUBTRACTION -> value1 - value2
            OperationType.MULTIPLICATION -> value1 * value2
            OperationType.DIVISION -> value1 / value2
        }
        return "$value1 ${operationType.symbol} $value2 is equal to $result"
    }
}

@Composable
fun Project132(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    fun runDemo() {
        val operation1 = Operation(10, 4, OperationType.ADDITION)
        outputText = operation1.perform()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { runDemo() }) {
            Text("Perform Operation")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputText)
    }

    // Run the demo automatically when the composable is first created
    LaunchedEffect(Unit) {
        runDemo()
    }
}