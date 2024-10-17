package com.example.cursokotlin.Units.Unit19

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
fun Project94(modifier: Modifier = Modifier, navController: NavHostController) {
    var name by remember { mutableStateOf("") } // Input for the name
    var hourlyRate by remember { mutableStateOf("") } // Input for hourly rate
    var hoursWorked by remember { mutableStateOf("") } // Input for hours worked
    var result by remember { mutableStateOf("") } // Store the result string

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input field for the name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for hourly rate
        OutlinedTextField(
            value = hourlyRate,
            onValueChange = { hourlyRate = it },
            label = { Text("Enter Hourly Rate") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for hours worked
        OutlinedTextField(
            value = hoursWorked,
            onValueChange = { hoursWorked = it },
            label = { Text("Enter Hours Worked") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the salary
        Button(
            onClick = {
                result = calculateSalary(
                    name,
                    hourlyRate.toDoubleOrNull() ?: 0.0,
                    hoursWorked.toIntOrNull() ?: 0
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Salary")
        }

        // Display the result
        Text(result)
    }
}

// Function to calculate salary
fun calculateSalary(name: String, hourlyRate: Double, hoursWorked: Int): String {
    val salary = hourlyRate * hoursWorked
    return "$name worked $hoursWorked hours at a rate of $hourlyRate, therefore their salary is $salary"
}
