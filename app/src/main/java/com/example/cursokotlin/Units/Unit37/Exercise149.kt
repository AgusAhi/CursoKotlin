package com.example.cursokotlin.Units.Unit37

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project149(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var firstNumber by remember { mutableStateOf("2") }
    var secondNumber by remember { mutableStateOf("3") }
    var result by remember { mutableStateOf("") }

    // Operation function
    fun operar(v1: Int, v2: Int, fn: (Int, Int) -> Int): Int {
        return fn(v1, v2)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Operations Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = firstNumber,
            onValueChange = { firstNumber = it },
            label = { Text("First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = secondNumber,
            onValueChange = { secondNumber = it },
            label = { Text("Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                val v1 = firstNumber.toIntOrNull() ?: 0
                val v2 = secondNumber.toIntOrNull() ?: 0
                val suma = operar(v1, v2) { x, y -> x + y }
                result = "Sum: $suma"
            }) {
                Text("Add")
            }

            Button(onClick = {
                val v1 = firstNumber.toIntOrNull() ?: 0
                val v2 = secondNumber.toIntOrNull() ?: 0
                val resta = operar(v1, v2) { x, y -> x - y }
                result = "Subtract: $resta"
            }) {
                Text("Subtract")
            }

            Button(onClick = {
                val v1 = firstNumber.toIntOrNull() ?: 0
                val v2 = secondNumber.toIntOrNull() ?: 0
                val power = operar(v1, v2) { x, y ->
                    var valor = 1
                    for(i in 1..y) valor *= x
                    valor
                }
                result = "Power: $power"
            }) {
                Text("Power")
            }
        }

        if (result.isNotEmpty()) {
            Text(
                text = result,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}