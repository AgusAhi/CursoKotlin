package com.example.cursokotlin.Units.Unit11

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
fun Project54(modifier: Modifier = Modifier, navController: NavHostController) {
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                val tableResult = StringBuilder()
                for (i in 1..10) {
                    val value = i * 5
                    tableResult.append("5 x $i = $value\n")
                }
                result = tableResult.toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Show Table of 5")
        }
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )
    }
}