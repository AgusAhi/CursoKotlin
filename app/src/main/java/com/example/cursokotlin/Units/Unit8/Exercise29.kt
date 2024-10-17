package com.example.cursokotlin.Units.Unit8

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
fun Project29(modifier: Modifier = Modifier, navController: NavHostController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter coord x") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter coord y") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
        )
        Button(
            onClick = {
                var x = number1.toInt()
                var y = number2.toInt()
                result = if (x > 0 && y > 0)
                    "Its on the first quadrant"
                else
                    if (x < 0 && y > 0)
                        "Its on the second quadrant"
                    else
                        if (x < 0 && y < 0)
                            "Its on the third quadrant"
                        else
                            if (x > 0 && y < 0)
                                "Its on the fourth quadrant"
                            else
                                "Its on the origin"
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
