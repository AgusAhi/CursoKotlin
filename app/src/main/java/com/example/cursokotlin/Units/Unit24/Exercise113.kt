package com.example.cursokotlin.Units.Unit24

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

@Composable
fun Project113( modifier: Modifier = Modifier, navController: NavHostController) {
    var lado1 by remember { mutableStateOf("") } // Side 1 input
    var lado2 by remember { mutableStateOf("") } // Side 2 input
    var lado3 by remember { mutableStateOf("") } // Side 3 input
    var resultLadoMayor by remember { mutableStateOf<String?>(null) } // Store largest side
    var resultEsEquilatero by remember { mutableStateOf<String?>(null) } // Store if triangle is equilateral

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter the sides of the triangle")

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

        // Button to calculate the largest side and check if equilateral
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

        // Display results
        resultLadoMayor?.let { BasicText(it) }
        resultEsEquilatero?.let { BasicText(it) }
    }
}




