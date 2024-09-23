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
fun Unit9(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project31") }) {
            Text("Go to Project 31")
        }
        Button(onClick = { navController.navigate("Project32") }) {
            Text("Go to Project 32")
        }
        Button(onClick = { navController.navigate("Units") }) {
            Text("Go Back")
        }
    }
}
