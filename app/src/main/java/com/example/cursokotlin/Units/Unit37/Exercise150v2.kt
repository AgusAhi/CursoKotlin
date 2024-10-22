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
fun Project150v2(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    // Helper function to print values that satisfy a condition
    fun printIf(vector: IntArray, fn: (Int) -> Boolean): String {
        return vector.filter(fn).joinToString(" ") + "\n"
    }

    // Generate random array
    val vector1 = remember {
        IntArray(10) { ((Math.random() * 100)).toInt() }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {
            outputText = buildString {
                append("Original array: ${vector1.joinToString(" ")}\n\n")

                append("Print values multiple of 2:\n")
                append(printIf(vector1) { it % 2 == 0 })

                append("Print values multiple of 3 or 5:\n")
                append(printIf(vector1) { it % 3 == 0 || it % 5 == 0 })

                append("Print values greater than or equal to 50:\n")
                append(printIf(vector1) { it >= 50 })

                append("Print values between 1-10, 20-30, 90-95:\n")
                append(printIf(vector1) {
                    when(it) {
                        in 1..10 -> true
                        in 20..30 -> true
                        in 90..95 -> true
                        else -> false
                    }
                })

                append("Print all values:\n")
                append(printIf(vector1) { true })
            }
        }) {
            Text("Generate Results")
        }

        Text(
            text = outputText,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}