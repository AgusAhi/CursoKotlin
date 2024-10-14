package com.example.cursokotlin.Unit21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Project98 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project98(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project98(modifier: Modifier = Modifier, navController: NavHostController) {
    var salaryInput by remember { mutableStateOf("") }
    var salaries by remember { mutableStateOf(IntArray(5)) }
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter 5 salaries")

        OutlinedTextField(
            value = salaryInput,
            onValueChange = { salaryInput = it },
            label = { Text("Enter salary ${currentIndex + 1}") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val salary = salaryInput.toIntOrNull()
                if (salary != null) {
                    salaries[currentIndex] = salary
                    currentIndex++
                    salaryInput = ""
                    if (currentIndex == 5) {
                        inputComplete = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !inputComplete && salaryInput.isNotEmpty()
        ) {
            Text("Submit (${currentIndex}/5)")
        }

        if (inputComplete) {
            Text("Entered Salaries:")
            LazyColumn {
                items(salaries.toList()) { salary ->
                    Text("$salary")
                }
            }

            Button(
                onClick = {
                    salaries = IntArray(5)
                    currentIndex = 0
                    inputComplete = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

fun inputSalaries(salaries: IntArray) {
    for (i in salaries.indices) {
        print("Enter salary:")
        salaries[i] = readLine()!!.toInt()
    }
}

fun displaySalaries(salaries: IntArray) {
    for (salary in salaries) {
        println(salary)
    }
}