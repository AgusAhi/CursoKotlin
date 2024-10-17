package com.example.cursokotlin.Units.Unit20

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
fun Project97(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var compareCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Compare 5 pairs of numbers")

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
                val num1 = value1.toIntOrNull()
                val num2 = value2.toIntOrNull()
                if (num1 != null && num2 != null) {
                    val greater = greater(num1, num2)
                    result += "The greater between $num1 and $num2 is $greater\n"
                    compareCount++
                    value1 = ""
                    value2 = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = compareCount < 5 && value1.isNotEmpty() && value2.isNotEmpty()
        ) {
            Text("Compare (${compareCount}/5)")
        }

        Text(result)

        if (compareCount == 5) {
            Button(
                onClick = {
                    compareCount = 0
                    result = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reset")
            }
        }
    }
}

fun greater(x1: Int, x2: Int) = if (x1 > x2) x1 else x2