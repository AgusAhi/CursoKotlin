package com.example.cursokotlin.Unit14

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

class Exercise70 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project70(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project70(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var sumResult by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Program that allows you to input two values.")
        Text("Calculates the sum of the values.")
        Text("Displays the result of the sum.")
        Text("*******************************")

        OutlinedTextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val num1 = value1.toIntOrNull() ?: 0
                val num2 = value2.toIntOrNull() ?: 0
                sumResult = num1 + num2
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Sum")
        }

        sumResult?.let {
            Text("The sum of the two values is: $it")
        }

        Text("*******************************")
        Text("Thank you for using this program")
    }
}
