package com.example.cursokotlin.Unit12

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

class Exercise59 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project59(modifier = Modifier, navController = rememberNavController()) // Establecer el contenido
        }
    }
}

@Composable
fun Project59(modifier: Modifier = Modifier, navController: NavHostController) {
    // Estados para manejar la entrada del usuario
    var xCoordinate by remember { mutableStateOf("") }
    var yCoordinate by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Llenar todo el tamaño disponible
            .padding(16.dp), // Agregar espacio alrededor
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado vertical entre los elementos
    ) {
        // Campo para ingresar la coordenada x
        OutlinedTextField(
            value = xCoordinate,
            onValueChange = { xCoordinate = it },
            label = { Text("Enter x coordinate") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para ingresar la coordenada y
        OutlinedTextField(
            value = yCoordinate,
            onValueChange = { yCoordinate = it },
            label = { Text("Enter y coordinate") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botón para determinar en qué cuadrante está el punto
        Button(
            onClick = {
                val x = xCoordinate.toIntOrNull() ?: 0
                val y = yCoordinate.toIntOrNull() ?: 0

                // Lógica para determinar el cuadrante
                result = when {
                    x > 0 && y > 0 -> "First Quadrant"
                    x < 0 && y > 0 -> "Second Quadrant"
                    x < 0 && y < 0 -> "Third Quadrant"
                    x > 0 && y < 0 -> "Fourth Quadrant"
                    else -> "The point is on an axis"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Determine Quadrant")
        }

        // Mostrar el resultado después de determinar el cuadrante
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
