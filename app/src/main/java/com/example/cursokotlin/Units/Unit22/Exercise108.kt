package com.example.cursokotlin.Units.Unit22

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
fun Project108(navController: NavHostController) {
    var numberInput by remember { mutableStateOf("") }
    var array by remember { mutableStateOf(IntArray(0)) } // Initially empty array
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter array size:")

        OutlinedTextField(
            value = numberInput,
            onValueChange = { numberInput = it },
            label = { Text("Enter size") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val size = numberInput.toIntOrNull()
                if (size != null && size > 0) {
                    array = IntArray(size) // Create array with specified size
                    currentIndex = 0
                    numberInput = ""
                    inputComplete = false
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = numberInput.isNotEmpty()
        ) {
            Text("Set Array Size")
        }

        if (array.isNotEmpty()) {
            Text("Enter elements:")

            OutlinedTextField(
                value = numberInput,
                onValueChange = { numberInput = it },
                label = { Text("Enter number ${currentIndex + 1}") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val number = numberInput.toIntOrNull()
                    if (number != null) {
                        array[currentIndex] = number
                        currentIndex++
                        numberInput = ""
                        if (currentIndex == array.size) {
                            inputComplete = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !inputComplete && numberInput.isNotEmpty()
            ) {
                Text("Submit (${currentIndex}/ ${array.size})")
            }
        }

        if (inputComplete) {
            Text("Array contents:")
            LazyColumn {
                itemsIndexed(array.toList()) { index, number ->
                    Text("${index + 1}: $number")
                }
            }

            // Functions for finding max and checking repetition
            val maxElement = findMax(array)
            val repeated = checkRepetition(array, maxElement)

            Text("Max element: $maxElement")
            if (repeated) {
                Text("Max element is repeated.")
            } else {
                Text("Max element is not repeated.")
            }

            Button(
                onClick = {
                    array = IntArray(0) // Reset to empty array
                    currentIndex = 0
                    inputComplete = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

// Function to find the maximum element (can be placed outside Project108)
fun findMax(array: IntArray): Int {
    var max = array[0]
    for (element in array) {
        if (element > max) {
            max = element
        }
    }
    return max
}

// Function to check if the maximum element is repeated (can be placed outside Project108)
fun checkRepetition(array: IntArray, maxElement: Int): Boolean {
    var count = 0
    for (element in array) {
        if (element == maxElement) {
            count++
        }
    }
    return count > 1
}