package com.example.cursokotlin.Units.Unit32

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Open class for Person
open class Person(val name: String, val age: Int) {
    open fun printDetails() {
        println("Name: $name")
        println("Age: $age")
    }
}

// Derived class Employee
class Employee(name: String, age: Int, val salary: Double) : Person(name, age) {
    override fun printDetails() {
        super.printDetails()
        println("Salary: $salary")
    }

    fun payTaxes() {
        if (salary > 3000)
            println("Employee $name pays taxes")
        else
            println("Employee $name does not pay taxes")
    }
}

// Jetpack Compose function with the requested modifier and navController
@Composable
fun Project137(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // State variables for dynamic input
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }

    // Layout
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter Person or Employee Data")

        // Input fields for name, age, and salary
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

        // Button to handle printing and checking
        Button(onClick = {
            val ageInt = age.toIntOrNull()
            val salaryDouble = salary.toDoubleOrNull()

            if (ageInt != null) {
                if (salaryDouble != null) {
                    // Employee instance
                    val employee = Employee(name, ageInt, salaryDouble)
                    employee.printDetails()
                    employee.payTaxes()
                } else {
                    // Person instance
                    val person = Person(name, ageInt)
                    person.printDetails()
                }
            } else {
                println("Invalid input for age")
            }
        }) {
            Text("Submit")
        }
    }
}

