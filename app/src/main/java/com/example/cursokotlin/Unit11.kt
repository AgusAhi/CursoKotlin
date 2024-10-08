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
        Button(onClick = { navController.navigate("Project52") }) { Text("Go to Project 52") }
        Button(onClick = { navController.navigate("Project53") }) { Text("Go to Project 53") }
        Button(onClick = { navController.navigate("Project54") }) { Text("Go to Project 54") }
        Button(onClick = { navController.navigate("Project55") }) { Text("Go to Project 55") }
        Button(onClick = { navController.navigate("Project56") }) { Text("Go to Project 56") }
        Button(onClick = { navController.navigate("Project57") }) { Text("Go to Project 57") }
        Button(onClick = { navController.navigate("Project58") }) { Text("Go to Project 58") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
