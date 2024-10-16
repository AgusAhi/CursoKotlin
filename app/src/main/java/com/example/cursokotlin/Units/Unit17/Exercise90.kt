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
fun Project90(modifier: Modifier = Modifier, navController: NavHostController) {
    var side1 by remember { mutableStateOf("") } // Input for the first rectangle's side 1
    var side2 by remember { mutableStateOf("") } // Input for the first rectangle's side 2
    var side3 by remember { mutableStateOf("") } // Input for the second rectangle's side 1
    var side4 by remember { mutableStateOf("") } // Input for the second rectangle's side 2
    var result by remember { mutableStateOf<String?>(null) } // Store the comparison result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the first rectangle's smaller side
        Text("First Rectangle")
        OutlinedTextField(
            value = side1,
            onValueChange = { side1 = it },
            label = { Text("Enter the smaller side of the rectangle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the first rectangle's larger side
        OutlinedTextField(
            value = side2,
            onValueChange = { side2 = it },
            label = { Text("Enter the larger side of the rectangle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second rectangle's smaller side
        Text("Second Rectangle")
        OutlinedTextField(
            value = side3,
            onValueChange = { side3 = it },
            label = { Text("Enter the smaller side of the rectangle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the second rectangle's larger side
        OutlinedTextField(
            value = side4,
            onValueChange = { side4 = it },
            label = { Text("Enter the larger side of the rectangle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the areas and compare them
        Button(
            onClick = {
                if (side1.isNotEmpty() && side2.isNotEmpty() && side3.isNotEmpty() && side4.isNotEmpty()) {
                    val area1 = returnSurface(side1.toInt(), side2.toInt())
                    val area2 = returnSurface(side3.toInt(), side4.toInt())

                    result = when {
                        area1 == area2 -> "Both rectangles have the same surface area"
                        area1 > area2 -> "The first rectangle has a greater surface area"
                        else -> "The second rectangle has a greater surface area"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Surface Area")
        }

        // Display the result of the comparison
        result?.let { Text(it) }
    }
}

// Function to calculate the surface area of a rectangle
fun returnSurface(side1: Int, side2: Int) = side1 * side2
