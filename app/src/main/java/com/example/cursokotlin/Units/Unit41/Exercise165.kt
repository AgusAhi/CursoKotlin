package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Person(val name: String, val age: Int) {
    fun print(): String {
        return "Name: $name and age is $age"
    }

    operator fun compareTo(person2: Person): Int {
        return when {
            age < person2.age -> -1
            age > person2.age -> 1
            else -> 0
        }
    }
}

@Composable
fun Project165(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var person1Name by remember { mutableStateOf("") }
    var person1Age by remember { mutableStateOf("") }
    var person2Name by remember { mutableStateOf("") }
    var person2Age by remember { mutableStateOf("") }
    var comparisonResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Person 1", style = MaterialTheme.typography.titleMedium)
                TextField(
                    value = person1Name,
                    onValueChange = { person1Name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = person1Age,
                    onValueChange = { person1Age = it },
                    label = { Text("Age") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Person 2", style = MaterialTheme.typography.titleMedium)
                TextField(
                    value = person2Name,
                    onValueChange = { person2Name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = person2Age,
                    onValueChange = { person2Age = it },
                    label = { Text("Age") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Button(
            onClick = {
                try {
                    val p1 = Person(person1Name, person1Age.toInt())
                    val p2 = Person(person2Name, person2Age.toInt())

                    comparisonResult = when {
                        p1 > p2 -> "${p1.print()} (Older)"
                        p1 < p2 -> "${p2.print()} (Older)"
                        else -> "They are the same age"
                    }
                } catch (e: NumberFormatException) {
                    comparisonResult = "Please enter valid ages"
                }
            },
            enabled = person1Name.isNotEmpty() && person1Age.isNotEmpty() &&
                    person2Name.isNotEmpty() && person2Age.isNotEmpty()
        ) {
            Text("Compare Ages")
        }

        // Example data button
        Button(
            onClick = {
                person1Name = "Juan"
                person1Age = "30"
                person2Name = "Ana"
                person2Age = "30"
            }
        ) {
            Text("Load Example Data")
        }

        comparisonResult?.let {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Button(
            onClick = {
                person1Name = ""
                person1Age = ""
                person2Name = ""
                person2Age = ""
                comparisonResult = null
            },
            enabled = person1Name.isNotEmpty() || person1Age.isNotEmpty() ||
                    person2Name.isNotEmpty() || person2Age.isNotEmpty()
        ) {
            Text("Clear")
        }
    }
}
