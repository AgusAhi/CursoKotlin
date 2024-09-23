package com.example.cursokotlin.Unit8

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

class Exercise27 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project27(modifier = Modifier, navController = rememberNavController())
        }
    }
}
@Composable
fun Project27(modifier: Modifier = Modifier, navController: NavHostController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter first value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter second value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number3,
            onValueChange = { number3 = it },
            label = { Text("Enter third value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var n1 = number1.toInt()
                var n2 = number2.toInt()
                var n3 = number3.toInt()
                result = if (n1 < 10 && n2 < 10 && n3 < 10)
                    "All numbers are less than 10"
                else
                    "Not all numbers are less than 10"
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
