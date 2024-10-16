package com.example.cursokotlin.Unit24

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

class Project112 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project112( modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project112( modifier: Modifier = Modifier, navController: NavHostController) {
    var personName by remember { mutableStateOf("") } // For storing person's name
    var personAge by remember { mutableStateOf("") }  // For storing person's age
    var persons by remember { mutableStateOf(mutableListOf<Person>()) } // List of persons

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input field for person's name
        OutlinedTextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Enter person's name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for person's age
        OutlinedTextField(
            value = personAge,
            onValueChange = { personAge = it },
            label = { Text("Enter person's age") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to add person
        Button(
            onClick = {
                val age = personAge.toIntOrNull()
                if (personName.isNotEmpty() && age != null) {
                    persons.add(Person(name = personName, age = age))
                    personName = ""
                    personAge = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = personName.isNotEmpty() && personAge.isNotEmpty()
        ) {
            Text("Add Person")
        }

        // Display the list of persons
        LazyColumn {
            items(persons) { person ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text("Name: ${person.name}")
                    Text("Age: ${person.age}")
                    Text("Status: ${person.getAgeStatus()}")
                }
            }
        }
    }
}

// Person class with properties and functions
data class Person(var name: String, var age: Int) {
    fun getAgeStatus(): String {
        return if (age >= 18) "$name is of legal age" else "$name is underage"
    }
}
