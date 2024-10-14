package com.example.cursokotlin.Unit21

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

class Project103 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project103(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project103(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberInput by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf(IntArray(8)) }
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter 8 integers")

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
                    numbers[currentIndex] = number
                    currentIndex++
                    numberInput = ""
                    if (currentIndex == 8) {
                        inputComplete = true
                        result = calculateArrayStats(numbers)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !inputComplete && numberInput.isNotEmpty()
        ) {
            Text("Submit (${currentIndex}/8)")
        }

        if (inputComplete) {
            Text("Entered numbers:")
            LazyColumn {
                itemsIndexed(numbers.toList()) { index, number ->
                    Text("${index + 1}: $number")
                }
            }

            Text(result)

            Button(
                onClick = {
                    numbers = IntArray(8)
                    currentIndex = 0
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

fun calculateArrayStats(vector: IntArray): String {
    var sum = 0
    var sumGreaterThan36 = 0
    var countGreaterThan50 = 0

    for (element in vector) {
        sum += element
        if (element > 36) sumGreaterThan36 += element
        if (element > 50) countGreaterThan50++
    }

    return """
        Total sum of the array: $sum
        Sum of elements greater than 36: $sumGreaterThan36
        Count of elements greater than 50: $countGreaterThan50
    """.trimIndent()
}