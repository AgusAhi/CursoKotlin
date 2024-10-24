package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size

data class Employee(
    val name: String,
    val salary: Double
)

@Composable
fun Project179(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var employees by remember {
        mutableStateOf(
            mutableListOf(
                Employee("John", 2000.0),
                Employee("Anna", 3500.0),
                Employee("Charles", 1500.0)
            )
        )
    }

    var showAddDialog by remember { mutableStateOf(false) }
    var newName by remember { mutableStateOf("") }
    var newSalary by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Employee Management",
            style = MaterialTheme.typography.headlineMedium
        )

        // Salary Statistics Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Salary Statistics",
                    style = MaterialTheme.typography.titleMedium
                )

                val totalSalary = employees.sumOf { it.salary }
                val averageSalary = if (employees.isNotEmpty()) {
                    totalSalary / employees.size
                } else 0.0

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Total Expenses")
                        Text(
                            "£${String.format("%.2f", totalSalary)}",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("Average Salary")
                        Text(
                            "£${String.format("%.2f", averageSalary)}",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                // Salary Distribution Chart
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(top = 16.dp)
                ) {
                    val maxSalary = employees.maxOfOrNull { it.salary } ?: 0.0
                    val barWidth = size.width / employees.size

                    employees.forEachIndexed { index, employee ->
                        val barHeight = (employee.salary / maxSalary) * size.height
                        drawRect(
                            color = Color(0xFF6200EE),
                            topLeft = Offset(index * barWidth, size.height - barHeight.toFloat()),
                            size = Size(barWidth * 0.8f, barHeight.toFloat())
                        )
                    }
                }
            }
        }

        // Employee List
        Card(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(employees) { employee ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(employee.name)
                            Text(
                                "£${String.format("%.2f", employee.salary)}",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }

        // Add Employee Button
        Button(
            onClick = { showAddDialog = true },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Employee")
        }
    }

    // Add Employee Dialog
    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Add New Employee") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = newSalary,
                        onValueChange = { newSalary = it },
                        label = { Text("Salary") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        newSalary.toDoubleOrNull()?.let { salary ->
                            if (newName.isNotBlank() && salary > 0) {
                                employees.add(Employee(newName, salary))
                                newName = ""
                                newSalary = ""
                                showAddDialog = false
                            }
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showAddDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}