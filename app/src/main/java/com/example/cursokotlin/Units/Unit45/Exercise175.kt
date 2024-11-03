package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project175(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Changed to mutableStateListOf for proper state management
    var ages = remember { mutableStateListOf(23, 67, 12, 35, 12) }
    var operationLog by remember { mutableStateOf("Initial list created") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mutable List Operations",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Current List Display
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Current List:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = if (ages.isEmpty()) "List is empty" else ages.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Operations Buttons
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Button(
                    onClick = {
                        if (ages.isNotEmpty()) {
                            ages[0] = 60
                            operationLog = "Modified first age to 60"
                        }
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Change First Age to 60")
                }
            }

            item {
                Button(
                    onClick = {
                        operationLog = "Average age: ${ages.average()}"
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Calculate Average Age")
                }
            }

            item {
                Button(
                    onClick = {
                        ages.add(50)
                        operationLog = "Added 50 to the end"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add 50 to End")
                }
            }

            item {
                Button(
                    onClick = {
                        ages.add(0, 17)
                        operationLog = "Added 17 at the beginning"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add 17 at Start")
                }
            }

            item {
                Button(
                    onClick = {
                        if (ages.isNotEmpty()) {
                            ages.removeAt(0)
                            operationLog = "Removed first age"
                        }
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Remove First Age")
                }
            }

            item {
                Button(
                    onClick = {
                        val count = ages.count { it >= 18 }
                        operationLog = "Adults (18+): $count"
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Count Adults (18+)")
                }
            }

            item {
                Button(
                    onClick = {
                        ages.removeAll { it == 12 }
                        operationLog = "Removed all ages of 12"
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Remove All Ages of 12")
                }
            }

            item {
                Button(
                    onClick = {
                        ages.clear()
                        operationLog = "Cleared all ages"
                    },
                    enabled = ages.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Clear List")
                }
            }

            item {
                // Operation Log Display
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Last Operation:",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = operationLog,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}