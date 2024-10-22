package com.example.cursokotlin.Units.Unit37

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project154(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    // Helper function to traverse array
    fun traverseAll(vector: IntArray, fn: (Int) -> Unit) {
        vector.forEach { fn(it) }
    }

    // Generate random array
    val vector1 = remember {
        mutableStateOf(IntArray(10) { (Math.random() * 100).toInt() })
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {
            // Generate new random array
            vector1.value = IntArray(10) { (Math.random() * 100).toInt() }

            outputText = buildString {
                append("Complete array listing:\n")
                append(vector1.value.joinToString(" "))
                append("\n\n")

                // Count multiples of 3
                var count = 0
                traverseAll(vector1.value) {
                    if (it % 3 == 0) count++
                }
                append("Number of elements divisible by 3: $count\n\n")

                // Sum elements greater than 50
                var sum = 0
                traverseAll(vector1.value) {
                    if (it > 50) sum += it
                }
                append("Sum of all elements greater than 50: $sum\n")

                // Additional statistics
                append("\nArray Statistics:\n")
                append("Minimum value: ${vector1.value.minOrNull()}\n")
                append("Maximum value: ${vector1.value.maxOrNull()}\n")
                append("Average value: ${vector1.value.average().format(2)}\n")
            }
        }) {
            Text("Generate New Array")
        }

        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

// Extension function to format double to 2 decimal places
private fun Double.format(digits: Int) = "%.${digits}f".format(this)