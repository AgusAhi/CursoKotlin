package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project174(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var currentInput by remember { mutableStateOf("") }
    var numbersList by remember { mutableStateOf(listOf<Int>()) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Enter 5 Integer Numbers",
            style = MaterialTheme.typography.titleLarge
        )

        // Input field
        TextField(
            value = currentInput,
            onValueChange = {
                currentInput = it
                errorMessage = ""
            },
            label = { Text("Enter an integer") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = errorMessage.isNotEmpty(),
            supportingText = if (errorMessage.isNotEmpty()) {
                { Text(errorMessage) }
            } else {
                { Text("${numbersList.size}/5 numbers entered") }
            }
        )

        // Add number button
        Button(
            onClick = {
                try {
                    val number = currentInput.toInt()
                    if (numbersList.size < 5) {
                        numbersList = numbersList + number
                        currentInput = ""
                        errorMessage = ""
                    }
                } catch (e: NumberFormatException) {
                    errorMessage = "Please enter a valid integer"
                }
            },
            enabled = currentInput.isNotEmpty() && numbersList.size < 5
        ) {
            Text("Add Number")
        }

        // Reset button
        if (numbersList.isNotEmpty()) {
            Button(
                onClick = {
                    numbersList = listOf()
                    currentInput = ""
                    errorMessage = ""
                }
            ) {
                Text("Reset List")
            }
        }

        // Show current list
        if (numbersList.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Current List:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = numbersList.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        // Show completion message
        if (numbersList.size == 5) {
            Text(
                text = "List is complete!",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}