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

class Exercise24 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project24(modifier = Modifier, navController = rememberNavController())
        }
    }
}
@Composable
fun Project24(modifier: Modifier = Modifier, navController: NavHostController) {
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
            label = { Text("Enter the day") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter the month") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number3,
            onValueChange = { number3 = it },
            label = { Text("Enter the year") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var day = number1.toInt()
                var month = number2.toInt()
                var year = number3.toInt()
                result = if (month == 1 || month == 2 || month == 3) {
                    "Its in the first quarter"
                } else
                    "error"
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
