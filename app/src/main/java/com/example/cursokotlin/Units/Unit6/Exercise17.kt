package com.example.cursokotlin.Units.Unit6

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
fun Project17(modifier: Modifier = Modifier, navController: NavHostController) {
    var value by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Enter a value between 1 and 99") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var n1 = value.toInt()
                result = if (n1 < 10) 1.toString() else 2.toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }
        Text(
            text = "The number has: $result digits",
            modifier = Modifier.padding(10.dp)
        )
    }
}
