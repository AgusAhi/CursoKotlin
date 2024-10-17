package com.example.cursokotlin.Units.Unit13

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
fun Project68(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var zeroCount by remember { mutableStateOf(0) }
    var specificCount by remember { mutableStateOf(0) }
    var currentIteration by remember { mutableStateOf(1) }
    var finished by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!finished) {
            Text("Enter integer value #$currentIteration:")

            OutlinedTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                label = { Text("Enter value") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val value = inputValue.toIntOrNull()
                    if (value != null) {
                        if (value == 0) {
                            zeroCount++
                        } else if (value == 1 || value == 5 || value == 10) {
                            specificCount++
                        }
                        currentIteration++
                        inputValue = "" // Clear input field

                        if (currentIteration > 10) {
                            finished = true // Mark as finished after 10 inputs
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        } else {
            // Display results after 10 inputs
            Text("Quantity of zeros entered: $zeroCount")
            Text("Quantity of numbers 1, 5, or 10 entered: $specificCount")
        }
    }
}
