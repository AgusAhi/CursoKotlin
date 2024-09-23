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

class Exercise32 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project32(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project32(modifier: Modifier = Modifier, navController: NavHostController) {
    var number1 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),  // Habilitamos el scroll vertical
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter the third value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                var x = number1.toInt()
                var output = ""
                var y = 1
                while (y <= x) {
                    output += "$y\n"
                    y += 1
                }
                result = output
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Mostrar números")
        }
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}
