package com.example.cursokotlin.Unit5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise74 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project74(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project74(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue1 by remember { mutableStateOf("") } // Input for the first value
    var inputValue2 by remember { mutableStateOf("") } // Input for the second value
    var result by remember { mutableStateOf<String?>(null) } // Store sum result
    var message by remember { mutableStateOf("El programa calcula la suma de dos valores ingresados por teclado.") } // Initial message
    var showMessage by remember { mutableStateOf(true) } // Control message display

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Show the initial message
        if (showMessage) {
            ShowMessage(message)
        }

        // Input for the first value
        OutlinedTextField(
            value = inputValue1,
            onValueChange = { inputValue1 = it },
            label = { Text("Ingrese el primer valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second value
        OutlinedTextField(
            value = inputValue2,
            onValueChange = { inputValue2 = it },
            label = { Text("Ingrese el segundo valor") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the sum
        Button(
            onClick = {
                val value1 = inputValue1.toIntOrNull() ?: 0 // Convert first input to int
                val value2 = inputValue2.toIntOrNull() ?: 0 // Convert second input to int
                result = (value1 + value2).toString() // Calculate the sum
                showMessage = false // Hide the initial message after calculation
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Suma")
        }

        // Display the result of the sum calculation
        if (result != null) {
            Text("La suma de los dos valores es: $result")
            ShowMessage("Gracias por utilizar este programa")
        }
    }
}

@Composable
fun ShowMessage(message: String) {
    Text(
        text = message,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}
