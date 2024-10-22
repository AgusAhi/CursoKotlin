package com.example.cursokotlin.Units.Unit39

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Project155(modifier: Modifier = Modifier, navController: NavHostController) {
    var outputText by remember { mutableStateOf("") }

    // Generate random array
    val vector1 = remember {
        mutableStateOf(IntArray(10) { (Math.random() * 100).toInt() })
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = {
            // Generate new random array
            vector1.value = IntArray(10) { (Math.random() * 100).toInt() }

            // Count multiples of 3
            var count = 0
            vector1.value.forEach {
                if (it % 3 == 0) count++
            }

            // Sum elements greater than 50
            var sum = 0
            vector1.value.forEach {
                if (it > 50) sum += it
            }

            outputText = buildString {
                append("Complete array listing:\n")
                append(vector1.value.joinToString(" "))
                append("\n\n")
                append("Number of elements divisible by 3: $count\n")
                append("Sum of all elements greater than 50: $sum")
            }
        }) {
            Text("Generate New Array")
        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (outputText.isNotEmpty()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Display array values in a row
                    Text("Array Values:", fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        vector1.value.forEach { number ->
                            Text(
                                text = number.toString(),
                                color = when {
                                    number % 3 == 0 -> androidx.compose.ui.graphics.Color.Blue  // Multiples of 3
                                    number > 50 -> androidx.compose.ui.graphics.Color.Green     // Greater than 50
                                    else -> androidx.compose.ui.graphics.Color.Gray             // Other numbers
                                }
                            )
                        }
                    }

                    // Display statistics
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Statistics:", fontWeight = FontWeight.Bold)

                    var count = 0
                    vector1.value.forEach { if (it % 3 == 0) count++ }
                    Text("Elements divisible by 3: $count")

                    var sum = 0
                    vector1.value.forEach { if (it > 50) sum += it }
                    Text("Sum of elements > 50: $sum")
                }
            }
        }
    }
}