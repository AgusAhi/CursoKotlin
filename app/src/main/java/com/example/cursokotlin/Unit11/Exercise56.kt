package com.example.cursokotlin.Unit11

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

class Exercise56 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project56(modifier = Modifier, navController = rememberNavController()) // Configurar el contenido con Project56
        }
    }
}

@Composable
fun Project56(modifier: Modifier = Modifier, navController: NavHostController) {
    // Variables de estado para contar los tipos de triángulos
    var numTriangles by remember { mutableStateOf("") }
    var side1 by remember { mutableStateOf("") }
    var side2 by remember { mutableStateOf("") }
    var side3 by remember { mutableStateOf("") }
    var equilateralCount by remember { mutableStateOf(0) }
    var isoscelesCount by remember { mutableStateOf(0) }
    var scaleneCount by remember { mutableStateOf(0) }
    var currentTriangle by remember { mutableStateOf(0) }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Usar todo el tamaño disponible
            .padding(16.dp), // Agregar espacio
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado vertical entre los elementos
    ) {
        // Campo para ingresar la cantidad de triángulos
        Text("Enter the number of triangles:")
        OutlinedTextField(
            value = numTriangles,
            onValueChange = { numTriangles = it },
            label = { Text("Number of triangles") },
            modifier = Modifier.fillMaxWidth()
        )

        // Si aún faltan triángulos por procesar
        if (currentTriangle < (numTriangles.toIntOrNull() ?: 0)) {
            Text("Enter the sides of triangle ${currentTriangle + 1}:")

            // Campos para ingresar los tres lados del triángulo
            OutlinedTextField(
                value = side1,
                onValueChange = { side1 = it },
                label = { Text("Side 1") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = side2,
                onValueChange = { side2 = it },
                label = { Text("Side 2") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = side3,
                onValueChange = { side3 = it },
                label = { Text("Side 3") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    // Convertir los lados a enteros
                    val s1 = side1.toIntOrNull() ?: 0
                    val s2 = side2.toIntOrNull() ?: 0
                    val s3 = side3.toIntOrNull() ?: 0

                    // Determinar el tipo de triángulo
                    if (s1 == s2 && s1 == s3) {
                        resultMessage = "It is an equilateral triangle."
                        equilateralCount++
                    } else if (s1 == s2 || s1 == s3 || s2 == s3) {
                        resultMessage = "It is an isosceles triangle."
                        isoscelesCount++
                    } else {
                        resultMessage = "It is a scalene triangle."
                        scaleneCount++
                    }

                    // Limpiar las entradas para el siguiente triángulo
                    side1 = ""
                    side2 = ""
                    side3 = ""
                    currentTriangle++
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Check Triangle")
            }

            // Mostrar el resultado de cada triángulo
            if (resultMessage.isNotEmpty()) {
                Text(resultMessage)
            }
        }

        // Mostrar resultados cuando se procesan todos los triángulos
        if (currentTriangle == (numTriangles.toIntOrNull() ?: 0)) {
            Text("Total equilateral triangles: $equilateralCount")
            Text("Total isosceles triangles: $isoscelesCount")
            Text("Total scalene triangles: $scaleneCount")

            // Botón para reiniciar el proceso
            Button(
                onClick = {
                    numTriangles = ""
                    side1 = ""
                    side2 = ""
                    side3 = ""
                    equilateralCount = 0
                    isoscelesCount = 0
                    scaleneCount = 0
                    currentTriangle = 0
                    resultMessage = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Restart")
            }
        }
    }
}
