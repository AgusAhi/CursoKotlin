package com.example.cursokotlin.Units.Unit11

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

@Composable
fun Project47(modifier: Modifier = Modifier, navController: NavHostController) {
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
        Text(
            text = result,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                for (i in 1..100) {
                    result += "$i\n"
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Show numbers 1 to 100")
        }
    }
}
