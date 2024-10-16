package com.example.cursokotlin.Units.Unit21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project104(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberInput by remember { mutableStateOf("") }
    var vector1 by remember { mutableStateOf(IntArray(4)) }
    var vector2 by remember { mutableStateOf(IntArray(4)) }
    var currentIndex by remember { mutableStateOf(0) }
    var currentVector by remember { mutableStateOf(1) }
    var inputComplete by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter 4 integers for each of the two arrays")

        OutlinedTextField(
            value = numberInput,
            onValueChange = { numberInput = it },
            label = { Text("Enter number ${currentIndex + 1} for Array $currentVector") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val number = numberInput.toIntOrNull()
                if (number != null) {
                    if (currentVector == 1) {
                        vector1[currentIndex] = number
                    } else {
                        vector2[currentIndex] = number
                    }
                    currentIndex++
                    numberInput = ""
                    if (currentIndex == 4) {
                        if (currentVector == 1) {
                            currentVector = 2
                            currentIndex = 0
                        } else {
                            inputComplete = true
                            result = sumArrays(vector1, vector2)
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !inputComplete && numberInput.isNotEmpty()
        ) {
            Text("Submit (Array $currentVector: ${currentIndex}/4)")
        }

        if (inputComplete) {
            Text("Array 1:")
            LazyColumn(modifier = Modifier.height(100.dp)) {
                itemsIndexed(vector1.toList()) { index, number ->
                    Text("${index + 1}: $number")
                }
            }

            Text("Array 2:")
            LazyColumn(modifier = Modifier.height(100.dp)) {
                itemsIndexed(vector2.toList()) { index, number ->
                    Text("${index + 1}: $number")
                }
            }

            Text("Result:")
            Text(result)

            Button(
                onClick = {
                    vector1 = IntArray(4)
                    vector2 = IntArray(4)
                    currentIndex = 0
                    currentVector = 1
                    inputComplete = false
                    result = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

fun sumArrays(vector1: IntArray, vector2: IntArray): String {
    val vectorSum = IntArray(4) { vector1[it] + vector2[it] }
    return vectorSum.joinToString("\n") { it.toString() }
}