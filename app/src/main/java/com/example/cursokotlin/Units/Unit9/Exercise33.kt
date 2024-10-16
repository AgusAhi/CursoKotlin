package com.example.cursokotlin.Units.Unit9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Project33(modifier: Modifier = Modifier, navController: NavHostController) {
    var number1 by remember { mutableStateOf("") }
    var x by remember { mutableStateOf(0) }
    var sum by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter a number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val num = number1.toIntOrNull()
                if (num != null && x <= 10) {
                    sum += num
                    x += 1
                    number1 = ""
                }
                if (x >= 10) {
                    val avg = sum / 10
                    "The sum is $sum\nAnd the average is $avg".also { result = it }
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add number $x/10")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
