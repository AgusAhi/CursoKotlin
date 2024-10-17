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
fun Project52(modifier: Modifier = Modifier, navController: NavHostController) {
    var triangleCount by remember { mutableStateOf(0) }
    var base by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0) }
    var countAreaGreaterThan12 by remember { mutableStateOf(0) }
    var trianglesProcessed by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el tamaño disponible
            .padding(16.dp), // Margen
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("How many triangles do you want to process?")
        OutlinedTextField(
            value = triangleCount.toString(),
            onValueChange = { triangleCount = it.toIntOrNull() ?: 0 },
            label = { Text("Number of triangles") },
            modifier = Modifier.fillMaxWidth()
        )

        if (trianglesProcessed < triangleCount) {
            Text("Enter the details for triangle ${trianglesProcessed + 1}:")
            OutlinedTextField(
                value = base,
                onValueChange = { base = it },
                label = { Text("Base") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val baseInt = base.toIntOrNull() ?: 0
                    val heightInt = height.toIntOrNull() ?: 0
                    area = (baseInt * heightInt) / 2

                    if (area > 12) {
                        countAreaGreaterThan12++
                    }
                    trianglesProcessed++
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calculate area")
            }

            if (area > 0) {
                Text("The area of the triangle is: $area")
            }
        }

        if (trianglesProcessed == triangleCount) {
            Text("Processed $trianglesProcessed triangles.")
            Text("The number of triangles with an area greater than 12 is: $countAreaGreaterThan12")

            Button(
                onClick = {
                    // Reiniciar el proceso
                    trianglesProcessed = 0
                    countAreaGreaterThan12 = 0
                    triangleCount = 0
                    base = ""
                    height = ""
                    area = 0
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}
