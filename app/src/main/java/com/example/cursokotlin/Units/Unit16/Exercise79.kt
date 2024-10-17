package com.example.cursokotlin.Units.Unit16

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
fun Project79(modifier: Modifier = Modifier, navController: NavHostController) {
    var side by remember { mutableStateOf("") } // Input for the side of the square
    var surface by remember { mutableStateOf<String?>(null) } // Store the calculated surface

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

        // Button to calculate the surface
        Button(
            onClick = {
                surface = if (side.isNotEmpty()) returnSurface(side.toInt()).toString() else null
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Surface")
        }

        // Display the calculated surface
        surface?.let { Text("The surface of the square is $it") }
    }
}

// Function to calculate the surface area of the square
fun returnSurface(side: Int): Int {
    return side * side
}
