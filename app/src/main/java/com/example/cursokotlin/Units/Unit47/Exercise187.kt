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
    var set by remember { mutableStateOf(setOf(2, 7, 20, 150, 3)) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Display current set content
        Text("Current Set Content:")
        Text(set.joinToString(" "))

        // Display set size
        Text("Set Size: ${set.size}")

        // Button to add 500
        Button(onClick = {
            set = set.toMutableSet().apply { add(500) }
            outputText = buildString {
                appendLine("Added 500 to the set:")
                appendLine(set.joinToString(" "))
            }
        }) {
            Text("Add 500")
        }

        // Check if 500 exists
        Button(onClick = {
            outputText = buildString {
                appendLine(if (500 in set) "500 is in the set" else "500 is not in the set")
                appendLine("\nCurrent set content:")
                appendLine(set.joinToString(" "))
            }
        }) {
            Text("Check for 500")
        }

        // Remove 500
        Button(onClick = {
            set = set.toMutableSet().apply { remove(500) }
            outputText = buildString {
                appendLine("Removed 500 from the set:")
                appendLine(set.joinToString(" "))
            }
        }) {
            Text("Remove 500")
        }

        // Count elements >= 10
        Button(onClick = {
            val count = set.count { it >= 10 }
            outputText = buildString {
                appendLine("Elements greater than or equal to 10: $count")
                appendLine("\nCurrent set content:")
                appendLine(set.joinToString(" "))
            }
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