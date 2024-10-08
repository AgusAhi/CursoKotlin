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

class Exercise66 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project66(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project66(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter an integer value between 1 and 5:")

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
                    1 -> "uno"
                    2 -> "dos"
                    3 -> "tres"
                    4 -> "cuatro"
                    5 -> "cinco"
                    else -> "valor fuera de rango" // Out of range message
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
