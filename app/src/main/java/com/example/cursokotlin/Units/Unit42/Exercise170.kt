package com.example.cursokotlin.Units.Unit42

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

fun sumar(vararg numeros: Int): Int {
    var suma = 0
    for(elemento in numeros) {
        suma += elemento
    }
    return suma
}

@Composable
fun Project170(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                val total = sumar(10, 20, 30, 40, 50)
                result = "Sum Result: $total"
            }
        ) {
            Text("Calculate Sum (10, 20, 30, 40, 50)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = result,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}