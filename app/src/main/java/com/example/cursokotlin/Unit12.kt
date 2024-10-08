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
fun Unit12(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project59") }) { Text("Go to Project 59") }
        Button(onClick = { navController.navigate("Project60") }) { Text("Go to Project 60") }
        Button(onClick = { navController.navigate("Project61") }) { Text("Go to Project 61") }
        Button(onClick = { navController.navigate("Project62") }) { Text("Go to Project 62") }
        Button(onClick = { navController.navigate("Project63") }) { Text("Go to Project 63") }
        Button(onClick = { navController.navigate("Project64") }) { Text("Go to Project 64") }
        Button(onClick = { navController.navigate("Project65") }) { Text("Go to Project 65") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
