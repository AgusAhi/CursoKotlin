package com.example.cursokotlin.Units.Unit18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project93(modifier: Modifier = Modifier, navController: NavHostController) {
    // Store inputs for the numbers
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    var number4 by remember { mutableStateOf("") }
    var number5 by remember { mutableStateOf("") }

    // Store the result
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input fields for numbers
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter first number") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter second number") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = number3,
            onValueChange = { number3 = it },
            label = { Text("Enter third number (optional)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = number4,
            onValueChange = { number4 = it },
            label = { Text("Enter fourth number (optional)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = number5,
            onValueChange = { number5 = it },
            label = { Text("Enter fifth number (optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the sum
        Button(
            onClick = {
                result = "Sum: ${sumar(
                    number1.toIntOrNull() ?: 0,
                    number2.toIntOrNull() ?: 0,
                    number3.toIntOrNull() ?: 0,
                    number4.toIntOrNull() ?: 0,
                    number5.toIntOrNull() ?: 0
                )}"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Sum")
        }

        // Display the result
        Text(result)
    }
}

// Function to calculate the sum of up to five numbers
fun sumar(v1: Int, v2: Int, v3: Int = 0, v4: Int = 0, v5: Int = 0) = v1 + v2 + v3 + v4 + v5