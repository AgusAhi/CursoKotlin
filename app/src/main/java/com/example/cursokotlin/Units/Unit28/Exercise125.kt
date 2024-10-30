package com.example.cursokotlin.Units.Unit28

import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Composable function for the main UI
@Composable
fun Project125(modifier: Modifier = Modifier, navController: NavHostController) {
    var personName by remember { mutableStateOf("") }
    var personAge by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    var displayAge by remember { mutableStateOf("") }

    val persona = remember { Persona() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Person Information", style = MaterialTheme.typography.titleLarge)

        // Input fields for name and age
        TextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = personAge,
            onValueChange = { personAge = it },
            label = { Text("Enter Age") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to submit and display name and age
        Button(onClick = {
            persona.name = personName
            persona.age = personAge.toIntOrNull() ?: 0
            displayName = persona.name
            displayAge = persona.age.toString()
        }) {
            Text(text = "Submit")
        }

        // Display the name and age
        Spacer(modifier = Modifier.height(16.dp))

        if (displayName.isNotEmpty()) {
            Text(text = "Name: $displayName")
        }
        if (displayAge.isNotEmpty()) {
            Text(text = "Age: $displayAge")
        }
    }
}

// Persona class with name and age handling logic
class Persona {
    var name: String = ""
        set(valor) {
            field = valor.uppercase() // Convert to uppercase
        }
        get() {
            return "($field)" // Return name in parentheses
        }

    var age: Int = 0
        set(valor) {
            field = if (valor >= 0) valor else 0 // Set age to 0 if negative
        }
}

