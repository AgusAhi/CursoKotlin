package com.example.cursokotlin.Units.Unit23

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
fun Project110(modifier: Modifier = Modifier, navController: NavHostController) {
    var lado1 by remember { mutableStateOf("") }
    var lado2 by remember { mutableStateOf("") }
    var lado3 by remember { mutableStateOf("") }
    var resultadoMayor by remember { mutableStateOf<String?>(null) }
    var resultadoEquilatero by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input fields for the triangle sides
        Text("Enter the three sides of the triangle:")

        OutlinedTextField(
            value = lado1,
            onValueChange = { lado1 = it },
            label = { Text("Side 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lado2,
            onValueChange = { lado2 = it },
            label = { Text("Side 2") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lado3,
            onValueChange = { lado3 = it },
            label = { Text("Side 3") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate the largest side and check if equilateral
        Button(
            onClick = {
                val side1 = lado1.toIntOrNull() ?: 0
                val side2 = lado2.toIntOrNull() ?: 0
                val side3 = lado3.toIntOrNull() ?: 0
                resultadoMayor = calculateLargestSide(side1, side2, side3)
                resultadoEquilatero = checkEquilateral(side1, side2, side3)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = lado1.isNotEmpty() && lado2.isNotEmpty() && lado3.isNotEmpty()
        ) {
            Text("Calculate")
        }

        // Display results for the largest side
        resultadoMayor?.let {
            Text("Largest side: $it")
        }

        // Display results if it's an equilateral triangle
        resultadoEquilatero?.let {
            Text(it)
        }
    }
}

// Function to calculate the largest side of the triangle
fun calculateLargestSide(lado1: Int, lado2: Int, lado3: Int): String {
    return when {
        lado1 > lado2 && lado1 > lado3 -> lado1.toString()
        lado2 > lado3 -> lado2.toString()
        else -> lado3.toString()
    }
}

// Function to check if the triangle is equilateral
fun checkEquilateral(lado1: Int, lado2: Int, lado3: Int): String {
    return if (lado1 == lado2 && lado1 == lado3) {
        "The triangle is equilateral."
    } else {
        "The triangle is not equilateral."
    }
}
