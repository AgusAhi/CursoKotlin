package com.example.cursokotlin.Units.Unit15

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
fun Project76(modifier: Modifier = Modifier, navController: NavHostController) {
    var lado by remember { mutableStateOf("") } // Input for the side length
    var resultado by remember { mutableStateOf<String?>(null) } // Store result
    var seleccion by remember { mutableStateOf("") } // Store selected option

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for the side length
        OutlinedTextField(
            value = lado,
            onValueChange = { lado = it },
            label = { Text("Ingrese el valor del lado de un cuadrado") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for the choice of perimeter or area
        OutlinedTextField(
            value = seleccion,
            onValueChange = { seleccion = it },
            label = { Text("Calcular perimetro o superficie") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to calculate
        Button(
            onClick = {
                val ladoInt = lado.toIntOrNull() ?: 0 // Convert input to Int
                resultado = when (seleccion.lowercase()) { // Lowercase for case-insensitive comparison
                    "perimetro" -> "El perímetro es ${calcularPerimetro(ladoInt)}"
                    "superficie" -> "La superficie es ${calcularSuperficie(ladoInt)}"
                    else -> "Opción no válida"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        // Display the result
        resultado?.let { Text(it) }
    }
}

fun calcularPerimetro(lado: Int): Int {
    return lado * 4
}

fun calcularSuperficie(lado: Int): Int {
    return lado * lado
}
