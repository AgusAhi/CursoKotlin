package com.example.cursokotlin.Unit12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise62 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project62(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project62(modifier: Modifier = Modifier, navController: NavHostController) {
    var totalSalary by remember { mutableStateOf(0) }
    var currentSalary by remember { mutableStateOf("") }
    var processedSalaries by remember { mutableStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!isFinished) {
            OutlinedTextField(
                value = currentSalary,
                onValueChange = { currentSalary = it },
                label = { Text("Enter the salary of the worker") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val salary = currentSalary.toIntOrNull() ?: 0
                    when {
                        salary > 5000 -> {
                            println("High salary")
                            totalSalary += salary
                        }
                        salary > 2000 -> {
                            println("Medium salary")
                        }
                        else -> {
                            println("Low salary")
                        }
                    }

                    processedSalaries++
                    currentSalary = ""

                    // Finish after processing 10 salaries
                    if (processedSalaries >= 10) {
                        isFinished = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Salary")
            }
        } else {
            Text("Total high salaries: $totalSalary")
        }
    }
}
