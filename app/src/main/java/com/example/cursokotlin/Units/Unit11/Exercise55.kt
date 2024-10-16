package com.example.cursokotlin.Units.Unit11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Importa los elementos de disposición
import androidx.compose.material3.* // Importa los componentes de Material3
import androidx.compose.runtime.* // Importa el estado y las funciones de recomposición
import androidx.compose.ui.Modifier // Modificador de UI
import androidx.compose.ui.unit.dp // Unidades de tamaño
import androidx.compose.ui.tooling.preview.Preview // Para previsualizaciones
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project55(modifier: Modifier = Modifier, navController: NavHostController) {
    // Estados para manejar el valor ingresado y la tabla de multiplicación
    var inputValue by remember { mutableStateOf("") }
    var resultList by remember { mutableStateOf(listOf<Int>()) }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el tamaño disponible
            .padding(16.dp), // Margen
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Campo para ingresar el valor entre 1 y 10
        Text("Enter a value between 1 and 10:")
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Value") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val number = inputValue.toIntOrNull() ?: 0
                if (number in 1..10) {
                    resultList = generateMultiplicationTable(number)
                    showResult = true
                } else {
                    showResult = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate Multiplication Table")
        }

        if (showResult) {
            Spacer(modifier = Modifier.height(20.dp))
            Text("Multiplication table for $inputValue:")
            resultList.forEach { value ->
                Text(value.toString())
            }
        }
    }
}

// Función para generar la tabla de multiplicar (12 términos)
fun generateMultiplicationTable(number: Int): List<Int> {
    return (1..12).map { it * number }
}
