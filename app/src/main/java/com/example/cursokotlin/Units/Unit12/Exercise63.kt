package com.example.cursokotlin.Units.Unit12

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

@Composable
fun Project63(modifier: Modifier = Modifier, navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Enter an integer value") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val value = inputValue.toIntOrNull()
                resultMessage = when {
                    value == null -> "Please enter a valid integer."
                    value == 0 -> "Zero was entered."
                    value > 0 -> "A positive value was entered."
                    else -> "A negative value was entered."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check Value")
        }

        Text(
            text = resultMessage,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
