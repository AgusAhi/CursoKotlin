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
fun Project18(modifier: Modifier = Modifier, navController: NavHostController) {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Enter first grade") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Enter second grade") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Enter third grade") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var n1 = (grade1.toInt() + grade2.toInt() + grade3.toInt()) / 3
                if (n1 >= 7)
                    result = "Passed"
                else if (n1 >= 4)
                    result = "Maybe"
                else
                    result = "Failed"
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
