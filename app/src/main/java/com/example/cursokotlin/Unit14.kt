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
fun Unit14(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project70") }) { Text("Go to Project 70") }
        Button(onClick = { navController.navigate("Project71") }) { Text("Go to Project 71") }
        Button(onClick = { navController.navigate("Project72") }) { Text("Go to Project 72") }
        Button(onClick = { navController.navigate("Project73") }) { Text("Go to Project 73") }
        Button(onClick = { navController.navigate("Units") }) { Text("Go Back") }
    }
}
