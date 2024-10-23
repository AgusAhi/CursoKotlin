package com.example.cursokotlin.Units.Unit40

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Extension function for printing string
fun String.print() {
    // This function remains for compatibility, but in Compose we'll use the string directly
}

@Composable
fun Project160(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var displayedStrings by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                // Simulating the original main function's behavior
                displayedStrings = listOf(
                    "Hello World",  // "Hola Mundo" in English
                    "End"          // "Fin" in English
                )
            }
        ) {
            Text("Display Strings")
        }

        // Display each string in the list
        displayedStrings.forEach { str ->
            Text(
                text = str,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

