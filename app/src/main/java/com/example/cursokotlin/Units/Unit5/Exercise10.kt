package com.example.cursokotlin.Units.Unit5

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
fun Project10(modifier: Modifier = Modifier, navController: NavHostController) {
    var salary by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text("Enter the salary of the employee") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {

                val salaryValue = salary.toDoubleOrNull()
                if (salaryValue != null) {
                    result = if (salaryValue > 3000.0) "Must pay taxes" else "No need to pay taxes"
                } else {
                    result = "Invalid salary"
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
