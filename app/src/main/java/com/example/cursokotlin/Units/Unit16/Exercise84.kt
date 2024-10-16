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
fun Project84(modifier: Modifier = Modifier, navController: NavHostController) {
    var side1 by remember { mutableStateOf("") } // Input for first rectangle's smaller side
    var side2 by remember { mutableStateOf("") } // Input for first rectangle's larger side
    var side3 by remember { mutableStateOf("") } // Input for second rectangle's smaller side
    var side4 by remember { mutableStateOf("") } // Input for second rectangle's larger side
    var result by remember { mutableStateOf<String?>(null) } // Store the comparison result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("First Rectangle")
        // Input for the first rectangle's smaller side
        OutlinedTextField(
            value = side1,
            onValueChange = { side1 = it },
            label = { Text("Enter the smaller side") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the first rectangle's larger side
        OutlinedTextField(
            value = side2,
            onValueChange = { side2 = it },
            label = { Text("Enter the larger side") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Second Rectangle")
        // Input for the second rectangle's smaller side
        OutlinedTextField(
            value = side3,
            onValueChange = { side3 = it },
            label = { Text("Enter the smaller side") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second rectangle's larger side
        OutlinedTextField(
            value = side4,
            onValueChange = { side4 = it },
            label = { Text("Enter the larger side") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to compare the rectangles' surfaces
        Button(
            onClick = {
                if (side1.isNotEmpty() && side2.isNotEmpty() && side3.isNotEmpty() && side4.isNotEmpty()) {
                    val surface1 = returnSurface(side1.toInt(), side2.toInt())
                    val surface2 = returnSurface(side3.toInt(), side4.toInt())

                    result = when {
                        surface1 == surface2 -> "Both rectangles have the same surface"
                        surface1 > surface2 -> "The first rectangle has a larger surface"
                        else -> "The second rectangle has a larger surface"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Compare Rectangles")
        }

        // Display the comparison result
        result?.let { Text(it) }
    }
}

// Function to calculate the surface of a rectangle
fun returnSurface(side1: Int, side2: Int): Int {
    return side1 * side2
}
