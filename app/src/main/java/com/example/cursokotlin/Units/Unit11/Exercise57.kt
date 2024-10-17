package com.example.cursokotlin.Units.Unit11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Importar componentes de diseño
import androidx.compose.material3.* // Importar Material3 componentes
import androidx.compose.runtime.* // Importar estados y recomposiciones
import androidx.compose.ui.Modifier // Modificadores de UI
import androidx.compose.ui.unit.dp // Unidades de medida
import androidx.navigation.NavHostController // Navegación
import androidx.navigation.compose.rememberNavController // Recuerdos del controlador de navegación

@Composable
fun Project57(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberOfPoints by remember { mutableStateOf("") }
    var xCoordinate by remember { mutableStateOf("") }
    var yCoordinate by remember { mutableStateOf("") }
    var quadrant1Count by remember { mutableStateOf(0) }
    var quadrant2Count by remember { mutableStateOf(0) }
    var quadrant3Count by remember { mutableStateOf(0) }
    var quadrant4Count by remember { mutableStateOf(0) }
    var currentPoint by remember { mutableStateOf(0) }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Usar todo el tamaño disponible
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter the number of points to input:")
        OutlinedTextField(
            value = numberOfPoints,
            onValueChange = { numberOfPoints = it },
            label = { Text("Number of points") },
            modifier = Modifier.fillMaxWidth()
        )

        if (currentPoint < (numberOfPoints.toIntOrNull() ?: 0)) {
            Text("Enter the coordinates of point ${currentPoint + 1}:")

            OutlinedTextField(
                value = xCoordinate,
                onValueChange = { xCoordinate = it },
                label = { Text("X Coordinate") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = yCoordinate,
                onValueChange = { yCoordinate = it },
                label = { Text("Y Coordinate") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val x = xCoordinate.toIntOrNull() ?: 0
                    val y = yCoordinate.toIntOrNull() ?: 0

                    when {
                        x > 0 && y > 0 -> {
                            resultMessage = "Point is in the first quadrant."
                            quadrant1Count++
                        }
                        x < 0 && y > 0 -> {
                            resultMessage = "Point is in the second quadrant."
                            quadrant2Count++
                        }
                        x < 0 && y < 0 -> {
                            resultMessage = "Point is in the third quadrant."
                            quadrant3Count++
                        }
                        x > 0 && y < 0 -> {
                            resultMessage = "Point is in the fourth quadrant."
                            quadrant4Count++
                        }
                    }

                    xCoordinate = ""
                    yCoordinate = ""
                    currentPoint++
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Check Point")
            }

            if (resultMessage.isNotEmpty()) {
                Text(resultMessage)
            }
        }

        if (currentPoint == (numberOfPoints.toIntOrNull() ?: 0)) {
            Text("Points in the first quadrant: $quadrant1Count")
            Text("Points in the second quadrant: $quadrant2Count")
            Text("Points in the third quadrant: $quadrant3Count")
            Text("Points in the fourth quadrant: $quadrant4Count")

            Button(
                onClick = {
                    numberOfPoints = ""
                    xCoordinate = ""
                    yCoordinate = ""
                    quadrant1Count = 0
                    quadrant2Count = 0
                    quadrant3Count = 0
                    quadrant4Count = 0
                    currentPoint = 0
                    resultMessage = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Restart")
            }
        }
    }
}
