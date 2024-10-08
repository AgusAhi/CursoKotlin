package com.example.cursokotlin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Unit13(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project66") }) { Text("Go to Project 66") }
        Button(onClick = { navController.navigate("Project67") }) { Text("Go to Project 67") }
        Button(onClick = { navController.navigate("Project68") }) { Text("Go to Project 68") }
        Button(onClick = { navController.navigate("Project69") }) { Text("Go to Project 69") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
