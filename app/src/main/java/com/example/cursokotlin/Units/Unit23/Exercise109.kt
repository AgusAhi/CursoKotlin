package com.example.cursokotlin.Units.Unit23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Person {
    var name: String = ""
    var age: Int = 0

    fun initialize(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun print() {
        println("Name: $name and has an age of $age")
    }

    fun checkIfAdult() {
        if (age >= 18) {
            println("$name is an adult")
        } else {
            println("$name is not an adult")
        }
    }
}
@Composable
fun Project109(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    var personName by remember { mutableStateOf("") }
    var personAge by remember { mutableStateOf("") }
    var outputMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter Person Details:")

        OutlinedTextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Enter name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = personAge,
            onValueChange = { personAge = it },
            label = { Text("Enter age") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val age = personAge.toIntOrNull() ?: 0
                val person = Person().apply {
                    initialize(personName, age)
                }
                person.print()
                person.checkIfAdult()

                // Update the output message
                outputMessage = "Created person: ${person.name}, age: ${person.age}"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Person")
        }

        // Display the output message
        if (outputMessage.isNotEmpty()) {
            Text(outputMessage)
        }
    }
}

// Main function for testing without Android
fun main() {
    val person1 = Person()
    person1.initialize("John", 12)
    person1.print()
    person1.checkIfAdult()

    val person2 = Person()
    person2.initialize("Anna", 50)
    person2.print()
    person2.checkIfAdult()
}