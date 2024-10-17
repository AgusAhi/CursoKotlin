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
fun Project12(modifier: Modifier = Modifier, navController: NavHostController) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Enter the first value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Enter the second value") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var n1 = value1.toInt()
                var n2 = value2.toInt()
                if (n1 < n2) {
                    val sum = n1 + n2
                    val difference = n1 - n2
                    result = "The sum of the two values is: $sum" +
                            "\n" + "The difference of the two values is: $difference"
                } else {
                    val product = n1 * n2
                    val division = n1 / n2
                    result = "The product of the two values is: $product" +
                            "\n" + "The division of the two values is: $division"
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
