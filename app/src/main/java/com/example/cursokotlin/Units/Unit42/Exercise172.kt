package com.example.cursokotlin.Units.Unit42

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

fun adultsQuantity(vararg ages: Int) = ages.count { it >= 18 }

@Composable
fun Project172(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var result by remember { mutableStateOf("") }
    // Cambiado a IntArray
    val edades = remember { intArrayOf(3, 65, 32, 23, 2, 98, 23, 45, 15) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ages to check: ${edades.joinToString(", ")}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val count = adultsQuantity(*edades)
                result = "Number of adults (18+): $count"
            }
        ) {
            Text("Count Adults")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = result,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
