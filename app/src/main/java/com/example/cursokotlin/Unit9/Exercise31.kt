package com.example.cursokotlin.Unit9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Exercise31 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project31(modifier = Modifier, navController = rememberNavController())
        }
    }
}

@Composable
fun Project31(modifier: Modifier = Modifier, navController: NavHostController) {
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
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                var output = ""
                var x = 1
                while (x <= 100) {
                    output += "$x\n"
                    x += 1
                }
                result = output
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Mostrar números")
        }
    }
}
