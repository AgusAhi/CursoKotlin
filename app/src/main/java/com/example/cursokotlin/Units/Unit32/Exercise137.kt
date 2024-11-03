package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Open class for Person
open class Person(val name: String, val age: Int) {
    open fun getDetails(): String {
        return "Name: $name\nAge: $age"
    }
}

// Derived class Employee
class Employee(name: String, age: Int, val salary: Double) : Person(name, age) {
    override fun getDetails(): String {
        return "${super.getDetails()}\nSalary: $salary"
    }

    fun getTaxStatus(): String {
        return if (salary > 3000)
            "Employee $name pays taxes"
        else
            "Employee $name does not pay taxes"
    }
}

@Composable
fun Project137(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Enter Person or Employee Data",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Age") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = salary,
                    onValueChange = { salary = it },
                    label = { Text("Salary (optional)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val ageInt = age.toIntOrNull()
                        val salaryDouble = salary.toDoubleOrNull()

                        outputText = when {
                            name.isEmpty() -> "Please enter a name"
                            ageInt == null -> "Invalid input for age"
                            salaryDouble != null -> {
                                val employee = Employee(name, ageInt, salaryDouble)
                                "${employee.getDetails()}\n${employee.getTaxStatus()}"
                            }
                            else -> {
                                val person = Person(name, ageInt)
                                person.getDetails()
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit")
                }
            }
        }

        // Output display
        if (outputText.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(scrollState)
                ) {
                    Text(
                        text = outputText,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}