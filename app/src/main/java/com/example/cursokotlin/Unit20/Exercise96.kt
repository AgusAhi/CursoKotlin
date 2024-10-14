package com.example.cursokotlin.Unit20

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

class Project96 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project96(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project96(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var inputCount by remember { mutableStateOf(0) }
    var mult2 by remember { mutableStateOf(0) }
    var mult5 by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter 10 values to count multiples of 2 and 5")

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter a value") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val value = inputValue.toIntOrNull()
                if (value != null) {
                    if (value % 2 == 0) mult2++
                    if (value % 5 == 0) mult5++
                    inputCount++
                    inputValue = ""

                    if (inputCount == 10) {
                        result = "Multiples of 2: $mult2\nMultiples of 5: $mult5"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = inputCount < 10 && inputValue.isNotEmpty()
        ) {
            Text("Submit (${inputCount}/10)")
        }

        Text(result)

        if (inputCount == 10) {
            Button(
                onClick = {
                    inputCount = 0
                    mult2 = 0
                    mult5 = 0
                    result = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

fun mult(n: Int, value: Int) = n % value == 0