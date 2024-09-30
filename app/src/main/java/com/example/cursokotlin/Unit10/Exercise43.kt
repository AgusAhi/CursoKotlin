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

class Exercise43 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project43(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project43(modifier: Modifier = Modifier, navController: NavHostController) {
    var totalValues by remember { mutableStateOf("") } // Number of values to be entered
    var currentValue by remember { mutableStateOf("") } // The current value the user is entering
    var remainingValues by remember { mutableStateOf(0) } // Tracks how many values are left to enter
    var result by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Asking how many values the user wants to enter
        if (remainingValues == 0) {
            OutlinedTextField(
                value = totalValues,
                onValueChange = { totalValues = it },
                label = { Text("How many numbers will you enter?") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    remainingValues = totalValues.toIntOrNull() ?: 0
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Confirm number of values")
            }
        } else if (remainingValues > 0) {
            // Allow the user to enter values one by one
            OutlinedTextField(
                value = currentValue,
                onValueChange = { currentValue = it },
                label = { Text("Enter a value") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
            )

            Button(
                onClick = {
                    val valor = currentValue.toIntOrNull()
                    if (valor != null) {
                        if (valor != 0) {
                            remainingValues++
                            result = totalValues
                            currentValue = ""
                        }
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Add value ($remainingValues remaining)")
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        // Display results once all values have been entered

        Text(
            text = "The average of the values entered is: $result",
            modifier = Modifier.padding(10.dp)
        )


    }
}
