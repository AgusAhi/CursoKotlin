package com.example.cursokotlin.Units.Unit7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project21(modifier: Modifier = Modifier, navController: NavHostController) {
    var number by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            label = { Text("Enter an integer number with 1, 2 or 3 digits") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                val n = number.toIntOrNull()
                if (n != null) {
                    result = if (n < 10)
                        "The number has 1 digit"
                    else if (n < 100)
                        "The number has 2 digits"
                    else if (n < 1000)
                        "The number has 3 digits"
                    else
                        "Error"
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }
        Text(
            text = "$result",
            modifier = Modifier.padding(10.dp)
        )
    }
}
