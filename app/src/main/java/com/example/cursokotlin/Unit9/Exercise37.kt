package com.example.cursokotlin.Unit9

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

class Exercise37 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project37(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project37(modifier: Modifier = Modifier, navController: NavHostController) {

    var numEmployees by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var totalEmployees by remember { mutableStateOf(0) }
    var count1 by remember { mutableStateOf(0) }
    var count2 by remember { mutableStateOf(0) }         // Counter for employees earning more than 300
    var totalExpenses by remember { mutableStateOf(0.0) }  // Total sum of the salaries
    var remainingEmployees by remember { mutableStateOf(0) } // Tracks remaining employees to enter

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (remainingEmployees == 0) {
            // Input to enter the number of employees
            OutlinedTextField(
                value = numEmployees,
                onValueChange = { numEmployees = it },
                label = { Text("Number of employees") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )
            Button(
                onClick = {
                    remainingEmployees = numEmployees.toIntOrNull() ?: 0
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Confirm number of employees")
            }
        } else {
            // Input to enter employee salaries
            OutlinedTextField(
                value = salary,
                onValueChange = { salary = it },
                label = { Text("Enter employee salary") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    val salaryDouble = salary.toDoubleOrNull()
                    if (salaryDouble != null) {
                        if (salaryDouble in 100.0..300.0) {
                            count1 += 1
                        } else if (salaryDouble > 300.0) {
                            count2 += 1
                        }
                        totalExpenses += salaryDouble
                        totalEmployees += 1
                        remainingEmployees -= 1
                    }
                    salary = ""
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Enter salary ($totalEmployees/${numEmployees})")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Remaining employees: $remainingEmployees",
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display results once all salaries have been entered
        if (remainingEmployees == 0 && totalEmployees > 0) {
            Text(
                text = "Number of employees with salaries between 100 and 300: $count1",
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Number of employees with salaries greater than 300: $count2",
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Total company expense on salaries: $totalExpenses",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
