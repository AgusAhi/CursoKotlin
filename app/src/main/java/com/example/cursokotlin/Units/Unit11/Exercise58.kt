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
fun Project58(modifier: Modifier = Modifier, navController: NavHostController) {
    var currentValue by remember { mutableStateOf("") }
    var negativeCount by remember { mutableStateOf(0) }
    var positiveCount by remember { mutableStateOf(0) }
    var multipleOf15Count by remember { mutableStateOf(0) }
    var evenSum by remember { mutableStateOf(0) }
    var currentIteration by remember { mutableStateOf(0) }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
                    val value = currentValue.toIntOrNull() ?: 0

                    if (value < 0) negativeCount++
                    else if (value > 0) positiveCount++

                    if (value % 15 == 0) multipleOf15Count++

                    if (value % 2 == 0) evenSum += value

                    currentValue = ""
                    currentIteration++

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

        if (resultMessage.isNotEmpty()) {
            Text(resultMessage)

            Button(
                onClick = {
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
