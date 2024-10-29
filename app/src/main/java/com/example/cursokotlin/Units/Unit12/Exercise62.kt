package com.example.cursokotlin.Units.Unit12

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project62(modifier: Modifier = Modifier, navController: NavHostController) {
    var totalSalary by remember { mutableStateOf(0) }
    var currentSalary by remember { mutableStateOf("") }
    var processedSalaries by remember { mutableStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Salary Calculator (${processedSalaries}/10)",
            style = MaterialTheme.typography.headlineMedium
        )

        if (!isFinished) {
            OutlinedTextField(
                value = currentSalary,
                onValueChange = { currentSalary = it },
                label = { Text("Enter the salary of the worker") },
                modifier = Modifier.fillMaxWidth(),
                isError = currentSalary.isNotEmpty() && currentSalary.toIntOrNull() == null,
                supportingText = {
                    if (currentSalary.isNotEmpty() && currentSalary.toIntOrNull() == null) {
                        Text("Please enter a valid number")
                    }
                }
            )

            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    color = when {
                        message.contains("High") -> MaterialTheme.colorScheme.error
                        message.contains("Medium") -> MaterialTheme.colorScheme.primary
                        else -> MaterialTheme.colorScheme.secondary
                    },
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = {
                    val salary = currentSalary.toIntOrNull()
                    if (salary != null) {
                        message = when {
                            salary > 5000 -> {
                                totalSalary += salary
                                "High salary"
                            }
                            salary > 2000 -> "Medium salary"
                            else -> "Low salary"
                        }

                        processedSalaries++
                        currentSalary = ""

                        if (processedSalaries >= 10) {
                            isFinished = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = currentSalary.toIntOrNull() != null
            ) {
                Text("Submit Salary")
            }
        } else {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Results",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Total high salaries: $${totalSalary}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Button(
                onClick = {
                    totalSalary = 0
                    processedSalaries = 0
                    isFinished = false
                    message = ""
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Start New Calculation")
            }
        }
    }
}