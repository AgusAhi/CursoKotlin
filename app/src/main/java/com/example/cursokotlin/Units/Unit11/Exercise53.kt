package com.example.cursokotlin.Units.Unit11

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

@Composable
fun Project53(modifier: Modifier = Modifier, navController: NavHostController) {
    var numbers by remember { mutableStateOf(listOf<Int>()) }
    var currentValue by remember { mutableStateOf("") }
    var sumLastFive by remember { mutableStateOf(0) }
    var remainingValues by remember { mutableStateOf(10) } // Will process 10 numbers
    var showResult by remember { mutableStateOf(false) }
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
            // Allow user to enter values one by one
            if (remainingValues > 0) {
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
                        val number = currentValue.toIntOrNull() ?: 0
                        numbers = numbers + number
                        remainingValues -= 1
                        currentValue = "" // Reset text field

                        // If 10 numbers have been entered, calculate the sum of the last 5
                        if (remainingValues == 0) {
                            sumLastFive = numbers.takeLast(5).sum()
                            showResult = true
                        }
                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Add value, remaining: $remainingValues")
                }
            }
        } else {
            // Show the sum of the last 5 values when all numbers have been processed
            Text(
                text = "The sum of the last 5 values is: $sumLastFive",
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Reset button
            Button(
                onClick = {
                    // Reset to start over
                    numbers = listOf()
                    sumLastFive = 0
                    remainingValues = 10
                    showResult = false
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Reset")
            }
        }
    }
}