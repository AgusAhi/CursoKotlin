package com.example.cursokotlin.Unit14

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

class Exercise71 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project71(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project71(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberOfCalculations by remember { mutableStateOf(5) } // Number of times to calculate sum
    var sumResults by remember { mutableStateOf<List<Int>>(emptyList()) } // Store results
    var currentValue1 by remember { mutableStateOf("") } // Input for first value
    var currentValue2 by remember { mutableStateOf("") } // Input for second value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Instructions
        Text("You can enter two values and calculate their sum.")
        Text("This will repeat for a total of $numberOfCalculations times.")

        // Input for the first value
        OutlinedTextField(
            value = currentValue1,
            onValueChange = { currentValue1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = currentValue2,
            onValueChange = { currentValue2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the sum
        Button(
            onClick = {
                val value1 = currentValue1.toIntOrNull() ?: 0 // Convert first value to int
                val value2 = currentValue2.toIntOrNull() ?: 0 // Convert second value to int
                val sum = value1 + value2 // Calculate sum
                sumResults = sumResults + sum // Add result to the list

                // Clear inputs after calculation
                currentValue1 = ""
                currentValue2 = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Sum")
        }

        // Display results for each calculation
        for (i in sumResults.indices) {
            Text("Result ${i + 1}: ${sumResults[i]}")
            // Separate each result
            if (i < sumResults.lastIndex) {
                Text("*******************************")
            }
        }

        // Limit the number of calculations
        if (sumResults.size >= numberOfCalculations) {
            Text("You have reached the maximum number of calculations.")
        }
    }
}
