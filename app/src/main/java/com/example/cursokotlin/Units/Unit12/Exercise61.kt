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
fun Project61(modifier: Modifier = Modifier, navController: NavHostController) {
    // State variables to hold counts
    var countAbove10_2 by remember { mutableStateOf(0) }
    var countBetween9_8And10_2 by remember { mutableStateOf(0) }
    var countBelow9_8 by remember { mutableStateOf(0) }
    var totalCount by remember { mutableStateOf(0) }
    var inputWeight by remember { mutableStateOf("") }
    var isFinished by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the entire available size
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.spacedBy(16.dp) // Vertical spacing between elements
    ) {
        // Input field for the weight
        OutlinedTextField(
            value = inputWeight,
            onValueChange = { inputWeight = it },
            label = { Text("Enter the weight of the piece (0 to finish)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to process the weight
        Button(
            onClick = {
                val weight = inputWeight.toDoubleOrNull() ?: 0.0 // Parse the input to double
                when {
                    weight > 10.2 -> countAbove10_2++
                    weight >= 9.8 -> countBetween9_8And10_2++
                    weight > 0 -> countBelow9_8++
                }

                if (weight == 0.0) {
                    isFinished = true // Mark as finished if the input is 0
                } else {
                    totalCount++ // Increment total count of pieces processed
                    inputWeight = "" // Clear the input field
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Process Weight")
        }

        // Display the results if finished
        if (isFinished) {
            Text("Pieces with a weight greater than 10.2: $countAbove10_2")
            Text("Pieces with a weight between 9.8 and 10.2: $countBetween9_8And10_2")
            Text("Pieces with a weight less than 9.8: $countBelow9_8")
            Text("Total pieces processed: $totalCount")
        }
    }
}
