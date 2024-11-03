package com.example.cursokotlin.Units.Unit42

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

enum class Operacion {
    SUM,
    AVERAGE
}

fun operate(operationType: Operacion, vararg fix: Int): Int {
    return when (operationType) {
        Operacion.SUM -> fix.sum()
        Operacion.AVERAGE -> fix.average().toInt()
    }
}

@Composable
fun Project171(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var sumResult by remember { mutableStateOf("") }
    var avgResult by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Operations with 10, 20, 30",
            style = MaterialTheme.typography.titleLarge
        )

        // Sum Button
        Button(
            onClick = {
                val resultado1 = operate(Operacion.SUM, 10, 20, 30)
                sumResult = "The sum is $resultado1"
            }
        ) {
            Text("Calculate Sum")
        }

        Text(
            text = sumResult,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Average Button
        Button(
            onClick = {
                val resultado2 = operate(Operacion.AVERAGE, 10, 20, 30)
                avgResult = "The average is $resultado2"
            }
        ) {
            Text("Calculate Average")
        }

        Text(
            text = avgResult,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}