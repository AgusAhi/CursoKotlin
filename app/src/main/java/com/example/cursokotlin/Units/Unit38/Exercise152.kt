package com.example.cursokotlin.Units.Unit38

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project152(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    // Generate random array with values between 0 and 10
    val vector = remember {
        mutableStateOf(IntArray(20) { (Math.random() * 11).toInt() })
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {
            // Generate new random array
            vector.value = IntArray(20) { (Math.random() * 11).toInt() }

            outputText = buildString {
                append("Complete array listing:\n")
                append(vector.value.joinToString(" "))
                append("\n\n")

                // Count elements less than or equal to 5
                val count = vector.value.count { it <= 5 }
                append("Number of elements less than or equal to 5: $count\n\n")

                // Check if all elements are less than or equal to 9
                if (vector.value.all { it <= 9 }) {
                    append("All elements are less than or equal to 9\n")
                } else {
                    append("Not all elements are less than or equal to 9\n")
                }

                // Check if any element equals 10
                if (vector.value.any { it == 10 }) {
                    append("At least one element is 10\n")
                } else {
                    append("No elements are equal to 10\n")
                }
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