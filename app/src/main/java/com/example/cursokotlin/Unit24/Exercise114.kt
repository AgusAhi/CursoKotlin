package com.example.cursokotlin.Unit24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Project114 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project114( modifier = Modifier, navController = rememberNavController())
        }
    }

    @Composable
    fun Project114( modifier: Modifier = Modifier, navController: NavHostController) {
        var lado1 by remember { mutableStateOf("") }
        var lado2 by remember { mutableStateOf("") }
        var lado3 by remember { mutableStateOf("") }
        var resultLadoMayor by remember { mutableStateOf<String?>(null) }
        var resultEsEquilatero by remember { mutableStateOf<String?>(null) }
        var useDefaultTriangle by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Enter the sides of the triangle or use a default triangle")

            if (!useDefaultTriangle) {
                // Input fields for the triangle sides
                OutlinedTextField(
                    value = lado1,
                    onValueChange = { lado1 = it },
                    label = { Text("Enter side 1") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = lado2,
                    onValueChange = { lado2 = it },
                    label = { Text("Enter side 2") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = lado3,
                    onValueChange = { lado3 = it },
                    label = { Text("Enter side 3") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Button to calculate with user input
                Button(
                    onClick = {
                        val l1 = lado1.toIntOrNull()
                        val l2 = lado2.toIntOrNull()
                        val l3 = lado3.toIntOrNull()
                        if (l1 != null && l2 != null && l3 != null) {
                            val triangulo = Triangulo(l1, l2, l3)
                            resultLadoMayor = "Largest side: ${triangulo.ladoMayor()}"
                            resultEsEquilatero = triangulo.esEquilatero()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = lado1.isNotEmpty() && lado2.isNotEmpty() && lado3.isNotEmpty()
                ) {
                    Text("Calculate")
                }
            }

            // Button to toggle between custom and default triangle
            Button(
                onClick = {
                    if (!useDefaultTriangle) {
                        val trianguloDefault = Triangulo(6, 6, 6)
                        resultLadoMayor = "Largest side: ${trianguloDefault.ladoMayor()}"
                        resultEsEquilatero = trianguloDefault.esEquilatero()
                    }
                    useDefaultTriangle = !useDefaultTriangle
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (!useDefaultTriangle) "Use default triangle (6, 6, 6)" else "Enter custom triangle")
            }

            // Display results
            resultLadoMayor?.let { BasicText(it) }
            resultEsEquilatero?.let { BasicText(it) }
        }
    }

    // Class with logic for triangle calculations
    class Triangulo(var lado1: Int, var lado2: Int, var lado3: Int) {
        // Function to determine the largest side
        fun ladoMayor(): Int {
            return when {
                lado1 > lado2 && lado1 > lado3 -> lado1
                lado2 > lado3 -> lado2
                else -> lado3
            }
        }

        // Function to check if the triangle is equilateral
        fun esEquilatero(): String {
            return if (lado1 == lado2 && lado1 == lado3) {
                "It is an equilateral triangle"
            } else {
                "It is not an equilateral triangle"
            }
        }
    }
}
