package com.example.cursokotlin.Unit12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise64 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project64(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project64(modifier: Modifier = Modifier, navController: NavHostController) {
    var sum by remember { mutableStateOf(0) }
    var firstValue by remember { mutableStateOf("") }
    var secondValue by remember { mutableStateOf("") }
    var thirdValue by remember { mutableStateOf("") }
    var roundsLeft by remember { mutableStateOf(5) }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (roundsLeft > 0) {
            Text("Enter values for round ${6 - roundsLeft}:")

            OutlinedTextField(
                value = firstValue,
                onValueChange = { firstValue = it },
                label = { Text("First value") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = secondValue,
                onValueChange = { secondValue = it },
                label = { Text("Second value") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = thirdValue,
                onValueChange = { thirdValue = it },
                label = { Text("Third value") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val val1 = firstValue.toIntOrNull() ?: 0
                    val val2 = secondValue.toIntOrNull() ?: 0
                    val val3 = thirdValue.toIntOrNull() ?: 0

                    sum += when {
                        val1 > val2 && val1 > val3 -> val1
                        val2 > val3 -> val2
                        else -> val3
                    }

                    roundsLeft -= 1
                    firstValue = ""
                    secondValue = ""
                    thirdValue = ""

                    // Show result if no rounds left
                    if (roundsLeft == 0) {
                        resultMessage = "The accumulated value of the highest numbers is: $sum"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calculate Maximum")
            }
        } else {
            // Show final result after all rounds
            Text(text = resultMessage)
        }
    }
}
