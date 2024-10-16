package com.example.cursokotlin.Units.Unit17

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
fun Project85(modifier: Modifier = Modifier, navController: NavHostController) {
    var side by remember { mutableStateOf("") } // Input for the side of the square
    var surface by remember { mutableStateOf<String?>(null) } // Store the calculated surface area

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the side of the square
        OutlinedTextField(
            value = side,
            onValueChange = { side = it },
            label = { Text("Enter the side of the square") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the surface area
        Button(
            onClick = {
                if (side.isNotEmpty()) {
                    surface = returnSurface(side.toInt()).toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Surface Area")
        }

        // Display the calculated surface area
        surface?.let { Text("The surface area of the square is $it") }
    }
}

// Function to calculate the surface area of a square
fun returnSurface(side: Int) = side * side
