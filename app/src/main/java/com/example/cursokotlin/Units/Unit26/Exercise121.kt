package com.example.cursokotlin.Units.Unit26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.material3.* // Material 3 for UI components
import androidx.compose.runtime.* // For managing state
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

// Composable function for the main UI
@Composable
fun Project121(modifier: Modifier = Modifier, navController: NavHostController) {
    val club = remember { Club() }
    var mayorAntiguedad by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Club Members", style = MaterialTheme.typography.titleLarge)

        // Display each member's name and seniority
        Text(text = "${club.socio1.nombre} has been a member for ${club.socio1.antiguedad} years.")
        Text(text = "${club.socio2.nombre} has been a member for ${club.socio2.antiguedad} years.")
        Text(text = "${club.socio3.nombre} has been a member for ${club.socio3.antiguedad} years.")

        // Button to evaluate and display the member with the most seniority
        Button(onClick = {
            mayorAntiguedad = club.mayorAntiguedad()
        }) {
            Text(text = "Find Member with Most Seniority")
        }

        if (mayorAntiguedad.isNotEmpty()) {
            Text(text = "Member with most seniority: $mayorAntiguedad")
        }
    }
}

// Data class representing a club member
class Socio(val nombre: String, val antiguedad: Int)

// Class representing the club with multiple members
class Club {
    val socio1 = Socio("Juan", 22)
    val socio2 = Socio("Ana", 34)
    val socio3 = Socio("Carlos", 1)

    // Function to find and return the member with the most seniority
    fun mayorAntiguedad(): String {
        return when {
            socio1.antiguedad > socio2.antiguedad && socio1.antiguedad > socio3.antiguedad -> socio1.nombre
            socio2.antiguedad > socio3.antiguedad -> socio2.nombre
            else -> socio3.nombre
        }
    }
}
