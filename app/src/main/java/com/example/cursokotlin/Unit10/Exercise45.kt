package com.example.cursokotlin.Unit9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise45 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project45(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project45(modifier: Modifier = Modifier, navController: NavHostController) {
    var currentValue by remember { mutableStateOf("") } // Input for the current value
    var sum by remember { mutableStateOf(0) } // Accumulator for the sum of values
    var isProcessFinished by remember { mutableStateOf(false) } // Tracks whether the process is done
    var resultMessage by remember { mutableStateOf("") } // Message displaying the result

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (!isProcessFinished) {
            // Input field for the user to enter a value
            OutlinedTextField(
                value = currentValue,
                onValueChange = { currentValue = it },
                label = { Text("Enter a value (9999 to finish)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    val value = currentValue.toIntOrNull()
                    if (value != null) {
                        if (value == 9999) {
                            // Finish the process when the user enters 9999
                            isProcessFinished = true
                            resultMessage = when {
                                sum == 0 -> "The accumulated value is zero."
                                sum > 0 -> "The accumulated value is positive."
                                else -> "The accumulated value is negative."
                            }
                        } else {
                            // Accumulate the value if it's not 9999
                            sum += value
                        }
                        currentValue = "" // Clear input field after each entry
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add value")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Show the accumulated sum so far
            Text(
                text = "Accumulated value: $sum",
                modifier = Modifier.padding(10.dp)
            )
        } else {
            // Show the result message after the process has finished
            Text(
                text = resultMessage,
                modifier = Modifier.padding(10.dp)
            )

            // Show the final sum
            Text(
                text = "Final accumulated value: $sum",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
