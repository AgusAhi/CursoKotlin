package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Vector2 {
    val array = IntArray(5)

    fun load() {
        for(i in array.indices) {
            array[i] = (Math.random() * 11 + 1).toInt()
        }
    }

    fun print(): String {
        return array.joinToString(" ")
    }

    operator fun times(value: Int): Vector2 {
        val result = Vector2()
        for(i in array.indices) {
            result.array[i] = array[i] * value
        }
        return result
    }
}

@Composable
fun Project163(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var vector by remember { mutableStateOf(Vector2()) }
    var multiplier by remember { mutableStateOf("10") }
    var result by remember { mutableStateOf<Vector2?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                vector = Vector2().apply { load() }
            }
        ) {
            Text("Generate Random Vector")
        }

        if (vector.array.any { it != 0 }) {
            ResultCard(
                title = "Original Vector:",
                content = vector.print()
            )

            TextField(
                value = multiplier,
                onValueChange = {
                    multiplier = it
                    try {
                        val value = it.toInt()
                        result = vector * value
                    } catch (e: NumberFormatException) {
                        // Handle invalid input
                    }
                },
                label = { Text("Multiplier") },
                modifier = Modifier.fillMaxWidth()
            )

            result?.let {
                ResultCard(
                    title = "Vector multiplied by $multiplier:",
                    content = it.print()
                )
            }

            // Example button for multiplying by 10
            Button(
                onClick = {
                    multiplier = "10"
                    result = vector * 10
                }
            ) {
                Text("Multiply by 10")
            }
        }
    }
}

@Composable
private fun ResultCard(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(title)
            Text(
                text = content,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
