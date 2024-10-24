package com.example.cursokotlin.Units.Unit47

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project187(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }
    var conjunto1 by remember { mutableStateOf(mutableSetOf(2, 7, 20, 150, 3)) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Display current set content
        Text("Current Set Content:")
        Text(conjunto1.joinToString(" "))

        // Display set size
        Text("Set Size: ${conjunto1.size}")

        // Button to add 500
        Button(onClick = {
            conjunto1.add(500)
            updateOutput(conjunto1) { "Added 500 to the set:\n${conjunto1.joinToString(" ")}" }
        }) {
            Text("Add 500")
        }

        // Check if 500 exists
        Button(onClick = {
            updateOutput(conjunto1) {
                if (500 in conjunto1) "500 is in the set"
                else "500 is not in the set"
            }
        }) {
            Text("Check for 500")
        }

        // Remove 500
        Button(onClick = {
            conjunto1.remove(500)
            updateOutput(conjunto1) { "Removed 500 from the set:\n${conjunto1.joinToString(" ")}" }
        }) {
            Text("Remove 500")
        }

        // Count elements >= 10
        Button(onClick = {
            val count = conjunto1.count { it >= 10 }
            updateOutput(conjunto1) { "Elements greater than or equal to 10: $count" }
        }) {
            Text("Count Elements ≥ 10")
        }

        // Output area
        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

private fun updateOutput(
    conjunto1: MutableSet<Int>,
    textProvider: () -> String
): String {
    return buildString {
        appendLine(textProvider())
        appendLine("\nCurrent set content:")
        appendLine(conjunto1.joinToString(" "))
    }
}