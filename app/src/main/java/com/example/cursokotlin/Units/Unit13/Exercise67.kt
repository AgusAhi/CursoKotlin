package com.example.cursokotlin.Units.Unit13

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
                val value = inputValue.toIntOrNull() // Safely convert input to an integer
                outputText = when (value) {
                    in 1..9 -> "It has 1 digit"
                    in 10..99 -> "It has 2 digits"
                    in 100..999 -> "It has 3 digits"
                    in 1000..9999 -> "It has 4 digits"
                    in 10000..99999 -> "It has 5 digits"
                    else -> "It is not within the specified range" // Out of range message
                }
            }
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
