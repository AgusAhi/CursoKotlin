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
fun Unit6(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project15") }) { Text("Go to Project 15") }
        Button(onClick = { navController.navigate("Project16") }) { Text("Go to Project 16") }
        Button(onClick = { navController.navigate("Project17") }) { Text("Go to Project 17") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
