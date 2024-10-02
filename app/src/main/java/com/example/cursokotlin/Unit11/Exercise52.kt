package com.example.cursokotlin.Unit11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise52 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project52(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project52(modifier: Modifier = Modifier, navController: NavHostController) {
    var quant by remember { mutableStateOf(0) }
    var value by remember { mutableStateOf(0) }
    var totalValues by remember { mutableStateOf("") }
    var currentValue by remember { mutableStateOf("") }
    var remainingValues by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) } // Variable to show the result
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!showResult) {
            // Asking how many values the user wants to enter
            if (remainingValues == 0) {
                OutlinedTextField(
                    value = totalValues,
                    onValueChange = { totalValues = it },
                    label = { Text("How many numbers will you enter?") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    singleLine = true,
                )
                Button(
                    onClick = {
                        remainingValues = totalValues.toIntOrNull() ?: 0
                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Confirm number of values")
                }
            } else if (remainingValues > 0) {
                // Allow the user to enter values one by one
                OutlinedTextField(
                    value = currentValue,
                    onValueChange = { currentValue = it },
                    label = { Text("Enter a value") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        value = currentValue.toIntOrNull() ?: 0
                        remainingValues -= 1
                        if (value % 2 == 0) {
                            quant += 1
                        }
                        currentValue = ""
                        // Show the result if no remaining values are left
                        if (remainingValues == 0) {
                            showResult = true
                        }
                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Add value, remaining: $remainingValues")
                }
            }
        } else {
            // Show the final result
            Text(
                text = "Total: $quant numbers are even",
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Button to go back
            Button(
                onClick = {
                    // Reset everything to start over
                    quant = 0
                    totalValues = ""
                    remainingValues = 0
                    showResult = false
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Back")
            }
        }
    }
}
