package com.example.cursokotlin.Units.Unit40

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Extension function for printing range
fun Int.upTo(end: Int): String {
    return buildString {
        for (value in this@upTo..end) {
            append("$value-")
        }
    }
}

@Composable
fun Project161(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var startValue by remember { mutableStateOf("") }
    var endValue by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input for start value
        TextField(
            value = startValue,
            onValueChange = { startValue = it },
            label = { Text("Start Value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input for end value
        TextField(
            value = endValue,
            onValueChange = { endValue = it },
            label = { Text("End Value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to generate range
        Button(
            onClick = {
                try {
                    val start = startValue.toInt()
                    val end = endValue.toInt()
                    val result = start.upTo(end)
                    results = results + result
                } catch (e: NumberFormatException) {
                    // Handle invalid input
                }
            }
        ) {
            Text("Generate Range")
        }

        // Example buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val result = 10.upTo(100)
                    results = results + result
                }
            ) {
                Text("10 to 100")
            }

            Button(
                onClick = {
                    val result = 5.upTo(10)
                    results = results + result
                }
            ) {
                Text("5 to 10")
            }
        }

        // Display results
        results.forEach { result ->
            Text(
                text = result,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        // Clear button
        if (results.isNotEmpty()) {
            Button(
                onClick = { results = emptyList() },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Clear Results")
            }
        }
    }
}
