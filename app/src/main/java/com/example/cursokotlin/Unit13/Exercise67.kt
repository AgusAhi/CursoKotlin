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

class Exercise67 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project67(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project67(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter a positive integer between 1 and 99,999:")

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter value") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val value = inputValue.toIntOrNull() // Convert input to integer safely
                outputText = when (value) {
                    in 1..9 -> "Tiene 1 dígito"
                    in 10..99 -> "Tiene 2 dígitos"
                    in 100..999 -> "Tiene 3 dígitos"
                    in 1000..9999 -> "Tiene 4 dígitos"
                    in 10000..99999 -> "Tiene 5 dígitos"
                    else -> "No se encuentra comprendido en el rango indicado" // Out of range message
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        // Display the output text based on the input value
        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
