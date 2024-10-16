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

class Project116 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project116(modifier = Modifier, navController = rememberNavController())
        }
    }

    @Composable
    fun Project116(modifier: Modifier, navController: NavHostController) {
        var xValue by remember { mutableStateOf("") }
        var yValue by remember { mutableStateOf("") }
        var resultCuadrante by remember { mutableStateOf<String?>(null) }
        var useDefaultPoints by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Enter coordinates or use default points")

            if (!useDefaultPoints) {
                // Input fields for the x and y coordinates
                OutlinedTextField(
                    value = xValue,
                    onValueChange = { xValue = it },
                    label = { Text("Enter X coordinate") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = yValue,
                    onValueChange = { yValue = it },
                    label = { Text("Enter Y coordinate") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Button to calculate cuadrante based on user input
                Button(
                    onClick = {
                        val x = xValue.toIntOrNull()
                        val y = yValue.toIntOrNull()
                        if (x != null && y != null) {
                            val punto = Punto(x, y)
                            resultCuadrante = "The point (${punto.x}, ${punto.y}) is in ${punto.retornarCuadrante()}"
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = xValue.isNotEmpty() && yValue.isNotEmpty()
                ) {
                    Text("Determine Cuadrante")
                }
            }

            // Button to toggle between custom input and default points
            Button(
                onClick = {
                    if (!useDefaultPoints) {
                        val puntos = listOf(
                            Punto(12, 3),
                            Punto(-4, 3),
                            Punto(-2, -2),
                            Punto(12, -5),
                            Punto(0, -5)
                        )
                        val results = puntos.map { punto ->
                            "The point (${punto.x}, ${punto.y}) is in ${punto.retornarCuadrante()}"
                        }.joinToString("\n")
                        resultCuadrante = results
                    }
                    useDefaultPoints = !useDefaultPoints
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (!useDefaultPoints) "Use default points" else "Enter custom point")
            }

            // Display result
            resultCuadrante?.let { BasicText(it) }
        }
    }

    // Punto class for handling the coordinates and determining the cuadrante
    class Punto(val x: Int, val y: Int) {
        fun retornarCuadrante(): String {
            return when {
                x > 0 && y > 0 -> "First Quadrant"
                x < 0 && y > 0 -> "Second Quadrant"
                x < 0 && y < 0 -> "Third Quadrant"
                x > 0 && y < 0 -> "Fourth Quadrant"
                else -> "On an Axis"
            }
        }
    }
}
