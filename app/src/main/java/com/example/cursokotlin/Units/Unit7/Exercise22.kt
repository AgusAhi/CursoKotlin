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
fun Project22(modifier: Modifier = Modifier, navController: NavHostController) {
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
            label = { Text("Enter the total of questions on the exam") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter the total of correct answers on the exam") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                val totalAnswers = number1.toIntOrNull()
                val correctAnswers = number2.toIntOrNull()
                var percentage = number3.toIntOrNull()
                if (correctAnswers != null && totalAnswers != null) {
                    percentage = (correctAnswers * 100) / totalAnswers
                }

                if (correctAnswers != null && percentage != null) {
                    result = if (percentage >= 90)
                        "Max level"
                    else if (percentage >= 75)
                        "Mid level"
                    else if (percentage >= 50)
                        "Bad level"
                    else
                        "Out of level"
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
