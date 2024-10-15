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

class Project102 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project102(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project102(modifier: Modifier = Modifier, navController: NavHostController) {
    var numberInput by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf(IntArray(10)) }
    var currentIndex by remember { mutableStateOf(0) }
    var inputComplete by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter 10 integers")

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
                    if (currentIndex == 10) {
                        inputComplete = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !inputComplete && numberInput.isNotEmpty()
        ) {
            Text("Submit (${currentIndex}/10)")
        }

        if (inputComplete) {
            Text("Entered numbers:")
            LazyColumn {
                itemsIndexed(numbers.toList()) { index, number ->
                    Text("${index + 1}: $number")
                }
            }

            Button(
                onClick = {
                    numbers = IntArray(10)
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

fun displayArray(vector: IntArray) {
    for (element in vector) {
        println(element)
    }
}