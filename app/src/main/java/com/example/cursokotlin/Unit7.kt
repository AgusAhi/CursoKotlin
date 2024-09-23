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
fun Unit7(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project18") }) {
            Text("Go to Project 18")
        }
        Button(onClick = { navController.navigate("Project19") }) {
            Text("Go to Project 19")
        }
        Button(onClick = { navController.navigate("Project20") }) {
            Text("Go to Project 20")
        }
        Button(onClick = { navController.navigate("Project21") }) {
            Text("Go to Project 21")
        }
        Button(onClick = { navController.navigate("Project22") }) {
            Text("Go to Project 22")
        }
        Button(onClick = { navController.navigate("Units") }) {
            Text("Go Back")
        }
    }
}
