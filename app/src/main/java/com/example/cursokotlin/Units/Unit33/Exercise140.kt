package com.example.cursokotlin.Units.Unit33

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Abstract class Operation
abstract class Operation(val value1: Int, val value2: Int) {
    protected var result: Int = 0
    abstract fun operate()
    fun print(): String {
        return "Result: $result"
    }
}

// Class Addition
class Addition(value1: Int, value2: Int) : Operation(value1, value2) {
    override fun operate() {
        result = value1 + value2
    }
}

// Class Subtraction
class Subtraction(value1: Int, value2: Int) : Operation(value1, value2) {
    override fun operate() {
        result = value1 - value2
    }
}

// Jetpack Compose function
@Composable
fun Project140(navController: NavHostController, modifier: Modifier = Modifier) {
    var additionResult by remember { mutableStateOf("") }
    var subtractionResult by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Button to trigger Addition
        Button(onClick = {
            val addition1 = Addition(10, 4)
            addition1.operate()
            additionResult = addition1.print()
        }) {
            Text(text = "Perform Addition", fontSize = 18.sp)
        }
        Text(text = additionResult, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Button to trigger Subtraction
        Button(onClick = {
            val subtraction1 = Subtraction(20, 5)
            subtraction1.operate()
            subtractionResult = subtraction1.print()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Perform Subtraction", fontSize = 18.sp)
        }
        Text(text = subtractionResult, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
