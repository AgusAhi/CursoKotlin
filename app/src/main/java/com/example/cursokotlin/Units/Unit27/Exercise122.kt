package com.example.cursokotlin.Units.Unit27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Composable function for the main UI
@Composable
fun Project122(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Operations", style = MaterialTheme.typography.titleLarge)

        // Input fields for value 1 and value 2
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate sum and difference
        Button(onClick = {
            val num1 = value1.toIntOrNull() ?: 0
            val num2 = value2.toIntOrNull() ?: 0
            result = calculateOperations(num1, num2)
        }) {
            Text(text = "Calculate")
        }

        // Display the result
        if (result.isNotEmpty()) {
            Text(text = result)
        }
    }
}

// Function to perform sum and subtraction and return the result as a string
private fun calculateOperations(value1: Int, value2: Int): String {
    val sum = value1 + value2
    val subtraction = value1 - value2
    return "The sum of $value1 and $value2 is $sum\n" +
            "The difference between $value1 and $value2 is $subtraction"
}
