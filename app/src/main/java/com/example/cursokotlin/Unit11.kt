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
fun Unit11(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project47") }) { Text("Go to Project 47") }
        Button(onClick = { navController.navigate("Project48") }) { Text("Go to Project 48") }
        Button(onClick = { navController.navigate("Project49") }) { Text("Go to Project 49") }
        Button(onClick = { navController.navigate("Project50") }) { Text("Go to Project 50") }
        Button(onClick = { navController.navigate("Project51") }) { Text("Go to Project 51") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
