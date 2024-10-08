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

class Exercise58 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project58(modifier = Modifier, navController = rememberNavController()) // Configurar el contenido con Project58
        }
    }
}

@Composable
fun Project58(modifier: Modifier = Modifier, navController: NavHostController) {
    // Variables de estado para almacenar los valores y los resultados
    var currentValue by remember { mutableStateOf("") }
    var negativeCount by remember { mutableStateOf(0) }
    var positiveCount by remember { mutableStateOf(0) }
    var multipleOf15Count by remember { mutableStateOf(0) }
    var evenSum by remember { mutableStateOf(0) }
    var currentIteration by remember { mutableStateOf(0) }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Usar todo el tamaño disponible
            .padding(16.dp), // Agregar espacio
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado vertical entre los elementos
    ) {
        // Campo para ingresar el valor actual
        if (currentIteration < 10) {
            Text("Enter a value for iteration ${currentIteration + 1} (10 total):")
            OutlinedTextField(
                value = currentValue,
                onValueChange = { currentValue = it },
                label = { Text("Value") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    // Convertir el valor a un entero
                    val value = currentValue.toIntOrNull() ?: 0

                    // Comprobar si el valor es negativo o positivo
                    if (value < 0) negativeCount++
                    else if (value > 0) positiveCount++

                    // Comprobar si el valor es múltiplo de 15
                    if (value % 15 == 0) multipleOf15Count++

                    // Comprobar si el valor es par y sumarlo si lo es
                    if (value % 2 == 0) evenSum += value

                    // Limpiar la entrada y avanzar a la siguiente iteración
                    currentValue = ""
                    currentIteration++

                    // Si ya se ingresaron 10 valores, mostrar los resultados
                    if (currentIteration == 10) {
                        resultMessage = """
                            Number of negative values: $negativeCount
                            Number of positive values: $positiveCount
                            Number of multiples of 15: $multipleOf15Count
                            Sum of even values: $evenSum
                        """.trimIndent()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Process Value")
            }
        }

        // Mostrar los resultados después de 10 iteraciones
        if (resultMessage.isNotEmpty()) {
            Text(resultMessage)

            // Botón para reiniciar el proceso
            Button(
                onClick = {
                    // Reiniciar todas las variables
                    currentValue = ""
                    negativeCount = 0
                    positiveCount = 0
                    multipleOf15Count = 0
                    evenSum = 0
                    currentIteration = 0
                    resultMessage = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Restart")
            }
        }
    }
}
