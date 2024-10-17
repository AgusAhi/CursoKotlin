package com.example.cursokotlin.Units.Unit12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Import layout components
import androidx.compose.material3.* // Import Material3 components
import androidx.compose.runtime.* // Import state and recomposition
import androidx.compose.ui.Modifier // Import UI modifiers
import androidx.compose.ui.unit.dp // Import unit dp
import androidx.navigation.NavHostController // Import navigation
import androidx.navigation.compose.rememberNavController // Remember navigation controller

@Composable
fun Project60(modifier: Modifier = Modifier, navController: NavHostController) {
    // State variables to hold grades and average
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the entire available size
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.spacedBy(16.dp) // Vertical spacing between elements
    ) {
        // Input field for the first grade
        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Enter first grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for the second grade
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Enter second grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for the third grade
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Enter third grade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the average and determine the result
        Button(
            onClick = {
                val nota1 = grade1.toIntOrNull() ?: 0
                val nota2 = grade2.toIntOrNull() ?: 0
                val nota3 = grade3.toIntOrNull() ?: 0
                val average = (nota1 + nota2 + nota3) / 3

                result = when {
                    average >= 7 -> "Promoted"
                    average >= 4 -> "Regular"
                    else -> "Free"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Average")
        }

        // Display the result
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
