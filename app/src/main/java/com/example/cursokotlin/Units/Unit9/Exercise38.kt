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
fun Project38(modifier: Modifier = Modifier, navController: NavHostController) {
    var x by remember { mutableStateOf(0) }
    var term by remember { mutableStateOf(0) }
    var result1 by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (x <= 24) {
                    term += 11
                    x += 1
                }
                result1 = term
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Next term")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "The $x" + "º term is $result1",
            modifier = Modifier.padding(10.dp)
        )
    }
}
