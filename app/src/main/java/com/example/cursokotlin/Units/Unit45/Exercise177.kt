package com.example.cursokotlin.Units.Unit45

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Person(
    var name: String,
    var age: Int
) {
    fun print() = "Name: $name is $age years old"

    fun isAdult(): String =
        if (age >= 18) "$name is an adult"
        else "$name is not an adult"
}

@Composable
fun Project177(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var people by remember {
        mutableStateOf(
            mutableListOf(
                Person("John", 22),
                Person("Anna", 19),
                Person("Mark", 12)
            )
        )
    }

    var newName by remember { mutableStateOf("") }
    var newAge by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Person Management",
            style = MaterialTheme.typography.headlineMedium
        )

        // Stats Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Statistics",
                    style = MaterialTheme.typography.titleMedium
                )
                Text("Total people: ${people.size}")
                Text("Adults (18+): ${people.count { it.age >= 18 }}")
            }
        }

        // Add Person Button
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Person")
        }

        // People List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(people) { person ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(person.print())
                        Text(
                            text = person.isAdult(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }

    // Add Person Dialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Add New Person") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Name") }
                    )
                    OutlinedTextField(
                        value = newAge,
                        onValueChange = { newAge = it },
                        label = { Text("Age") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        newAge.toIntOrNull()?.let { age ->
                            if (newName.isNotBlank() && age >= 0) {
                                people.add(Person(newName, age))
                                newName = ""
                                newAge = ""
                                showDialog = false
                            }
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}