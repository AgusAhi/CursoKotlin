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
fun Unit10(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button (onClick = { navController.navigate("Project42") }) {
            Text("Go to Project 42")
        }
        Button(onClick = { navController.navigate("Project43") }) {
            Text("Go to Project 43")
        }
        Button(onClick = { navController.navigate("Units") }) {
            Text("Go Back")
        }
    }
}
