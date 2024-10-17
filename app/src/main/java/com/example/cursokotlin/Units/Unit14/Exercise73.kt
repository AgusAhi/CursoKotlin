package com.example.cursokotlin.Units.Unit14

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
fun Project73(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue1 by remember { mutableStateOf("") } // Input for the first value
    var inputValue2 by remember { mutableStateOf("") } // Input for the second value
    var inputValue3 by remember { mutableStateOf("") } // Input for the third value
    var minValueResult by remember { mutableStateOf<String?>(null) } // Store minimum value result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first value
        OutlinedTextField(
            value = inputValue1,
            onValueChange = { inputValue1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = inputValue2,
            onValueChange = { inputValue2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the third value
        OutlinedTextField(
            value = inputValue3,
            onValueChange = { inputValue3 = it },
            label = { Text("Enter third value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to find the minimum value
        Button(
            onClick = {
                val value1 = inputValue1.toIntOrNull() ?: Int.MAX_VALUE // Convert first input to int
                val value2 = inputValue2.toIntOrNull() ?: Int.MAX_VALUE // Convert second input to int
                val value3 = inputValue3.toIntOrNull() ?: Int.MAX_VALUE // Convert third input to int

                // Determine the minimum value
                minValueResult = when {
                    value1 < value2 && value1 < value3 -> value1.toString()
                    value2 < value3 -> value2.toString()
                    else -> value3.toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Find Minimum Value")
        }

        // Display the result of the minimum value calculation
        if (minValueResult != null) {
            Text("The minimum value is: $minValueResult")
        }
    }
}
