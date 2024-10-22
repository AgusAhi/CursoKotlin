package com.example.cursokotlin.Units.Unit38

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project153(modifier: Modifier = Modifier, navController: NavHostController) {
    var currentInput by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf(List(10) { 0f }) }
    var currentIndex by remember { mutableStateOf(0) }
    var outputText by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Enter 10 float numbers (${currentIndex + 1}/10):")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = currentInput,
                onValueChange = {
                    currentInput = it
                    showError = false
                },
                label = { Text("Enter number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.weight(1f),
                isError = showError
            )

            Button(
                onClick = {
                    try {
                        val number = currentInput.toFloat()
                        val newList = numbers.toMutableList()
                        newList[currentIndex] = number
                        numbers = newList

                        if (currentIndex < 9) {
                            currentIndex++
                            currentInput = ""
                        } else {
                            // All numbers entered, perform analysis
                            outputText = buildString {
                                append("Complete array listing:\n")
                                append(numbers.joinToString(" "))
                                append("\n\n")

                                val count = numbers.count { it < 50 }
                                append("Number of values less than 50: $count\n\n")

                                if (numbers.all { it < 50 }) {
                                    append("All values are less than 50\n")
                                } else {
                                    append("Not all values are less than 50\n")
                                }
                            }
                        }
                    } catch (e: NumberFormatException) {
                        showError = true
                    }
                },
                enabled = currentInput.isNotEmpty()
            ) {
                Text(if (currentIndex < 9) "Next" else "Analyze")
            }
        }

        if (showError) {
            Text(
                text = "Please enter a valid number",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Display current numbers
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(numbers.take(currentIndex)) { number ->
                Text("$number")
            }
        }

        // Display analysis results
        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Reset button
        if (currentIndex > 0) {
            Button(
                onClick = {
                    currentIndex = 0
                    currentInput = ""
                    numbers = List(10) { 0f }
                    outputText = ""
                    showError = false
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Reset")
            }
        }
    }
}