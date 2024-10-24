package com.example.cursokotlin.Units.Unit47

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cursokotlin.Units.Unit47.matematica.sumar
import com.example.cursokotlin.Units.Unit47.matematica.restar

@Composable
fun Project190(modifier: Modifier = Modifier, navController: NavHostController) {
    val sumResult = remember { sumar(5, 7) }
    val subtractResult = remember { restar(10, 3) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Math Functions Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        // Card for addition result
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Addition Example",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "5 + 7 = $sumResult",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "La suma es $sumResult",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        // Card for subtraction result
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Subtraction Example",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "10 - 3 = $subtractResult",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "La resta es $subtractResult",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        // Adding an interactive section
        var num1 by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var currentResult by remember { mutableStateOf<Pair<String, Int>?>(null) }

        Text(
            text = "Try Your Own Numbers",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Number inputs
        OutlinedTextField(
            value = num1,
            onValueChange = { if (it.isEmpty() || it.matches(Regex("^\\d*$"))) num1 = it },
            label = { Text("First Number") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { if (it.isEmpty() || it.matches(Regex("^\\d*$"))) num2 = it },
            label = { Text("Second Number") },
            modifier = Modifier.fillMaxWidth()
        )

        // Operation buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (num1.isNotEmpty() && num2.isNotEmpty()) {
                        val result = sumar(num1.toInt(), num2.toInt())
                        currentResult = "Sum" to result
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Add")
            }

            Button(
                onClick = {
                    if (num1.isNotEmpty() && num2.isNotEmpty()) {
                        val result = restar(num1.toInt(), num2.toInt())
                        currentResult = "Difference" to result
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Subtract")
            }
        }

        // Display current result
        currentResult?.let { (operation, result) ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = operation,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = result.toString(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}