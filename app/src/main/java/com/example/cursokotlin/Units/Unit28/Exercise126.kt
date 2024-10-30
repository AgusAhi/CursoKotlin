package com.example.cursokotlin.Units.Unit28

import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Composable function for the main UI
@Composable
fun Project126(modifier: Modifier = Modifier, navController: NavHostController) {
    var employeeName by remember { mutableStateOf("") }
    var employeeSalary by remember { mutableStateOf("") }
    var displayEmployeeInfo by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Employee Information", style = MaterialTheme.typography.titleLarge)

        // Input fields for name and salary
        TextField(
            value = employeeName,
            onValueChange = { employeeName = it },
            label = { Text("Enter Employee Name") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = employeeSalary,
            onValueChange = { employeeSalary = it },
            label = { Text("Enter Employee Salary") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to submit and display employee information
        Button(onClick = {
            val employee = Employee(employeeName, employeeSalary.toDoubleOrNull() ?: 0.0)
            displayEmployeeInfo = employee.print()
        }) {
            Text(text = "Submit")
        }

        // Display the employee info
        Spacer(modifier = Modifier.height(16.dp))

        if (displayEmployeeInfo.isNotEmpty()) {
            Text(text = displayEmployeeInfo)
        }
    }
}

// Employee class with name and salary validation
class Employee(var name: String, salary: Double) {
    var salary: Double = 0.0
        set(value) {
            field = if (value < 0) 0.0 else value // Set salary to 0 if negative
        }

    init {
        this.salary = salary
    }

    // Function to return employee information as a string for display
    fun print(): String {
        return "$name has a salary of $salary"
    }
}
