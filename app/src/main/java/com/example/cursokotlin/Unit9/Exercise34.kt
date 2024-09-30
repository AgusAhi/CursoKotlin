package com.example.cursokotlin.Unit9

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

class Exercise34 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project34(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project34(modifier: Modifier = Modifier, navController: NavHostController) {
    var number1 by remember { mutableStateOf("") }
    var acc by remember { mutableStateOf(0) }
    var large by remember { mutableStateOf("") }
    var quant by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf("") }
    var result2 by remember { mutableStateOf("") }
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
            label = { Text("How many pieces its gona make") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        Button(
            onClick = {
                val num = number1.toIntOrNull()
                if (num != null) {
                    result = "$num"
                    number1 = ""
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Number Added: $result")
        }

        OutlinedTextField(
            value = large,
            onValueChange = { large = it },
            label = { Text("Enter the large of the piece") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val l = large.toFloatOrNull()
                if (l != null) {
                    if (l >= 1.20f && l <= 1.30f) {
                        quant += 1
                        acc += 1
                        large = ""
                    }
                }
                result2 = "$quant"
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Check")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "The number of fit pieces is: $result2",
            modifier = Modifier.padding(10.dp)
        )
    }
}
