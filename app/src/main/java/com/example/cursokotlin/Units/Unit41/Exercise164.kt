package com.example.cursokotlin.Units.Unit41

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Vector3 {
    val array = IntArray(5)

    fun load() {
        for(i in array.indices) {
            array[i] = (Math.random() * 11 + 1).toInt()
        }
    }

    fun print(): String {
        return array.joinToString(" ")
    }

    operator fun inc(): Vector3 {
        val incrementResult = Vector3()
        for(i in array.indices) {
            incrementResult.array[i] = array[i] + 1
        }
        return incrementResult
    }

    operator fun dec(): Vector3 {
        val decrementResult = Vector3()
        for(i in array.indices) {
            decrementResult.array[i] = array[i] - 1
        }
        return decrementResult
    }
}

@Composable
fun Project164(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var vector by remember { mutableStateOf(Vector3()) }
    var operationHistory by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                vector = Vector3().apply { load() }
                operationHistory = listOf("Original Vector" to vector.print())
            }
        ) {
            Text("Generate Random Vector")
        }

        if (vector.array.any { it != 0 }) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        vector++
                        operationHistory = operationHistory + ("After increment (++)" to vector.print())
                    }
                ) {
                    Text("Increment (++)")
                }

                Button(
                    onClick = {
                        vector--
                        operationHistory = operationHistory + ("After decrement (--)" to vector.print())
                    }
                ) {
                    Text("Decrement (--)")
                }
            }

            // Display operation history
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                operationHistory.forEach { (operation, result) ->
                    ResultCard(
                        title = operation,
                        content = result
                    )
                }
            }

            if (operationHistory.isNotEmpty()) {
                Button(
                    onClick = {
                        operationHistory = emptyList()
                        vector = Vector3()
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Clear")
                }
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
