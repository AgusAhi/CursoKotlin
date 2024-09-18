package com.example.cursokotlin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Unit7(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { navController.navigate("Project18") }) {
            Text("Go to Project 18")
        }
        Button(onClick = { navController.navigate("Project19") }) {
            Text("Go to Project 19")
        }
        Button(onClick = { navController.navigate("Units") }) {
            Text("Go Back")
        }
    }
}
