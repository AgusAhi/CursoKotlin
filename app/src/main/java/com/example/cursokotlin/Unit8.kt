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
fun Unit8(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("Project23") }) {
            Text("Go to Project 23")
        }
        Button(onClick = { navController.navigate("Project24") }) {
            Text("Go to Project 24")
        }
        Button(onClick = { navController.navigate("Project25") }) {
            Text("Go to Project 25")
        }
        Button(onClick = { navController.navigate("Project26") }) {
            Text("Go to Project 26")
        }
        Button(onClick = { navController.navigate("Project27") }) {
            Text("Go to Project 27")
        }
        Button(onClick = { navController.navigate("Project28") }) {
            Text("Go to Project 28")
        }
        Button(onClick = { navController.navigate("Project29") }) {
            Text("Go to Project 29")
        }
        Button(onClick = { navController.navigate("Project30") }) {
            Text("Go to Project 30")
        }
        Button(onClick = { navController.navigate("Units") }) {
            Text("Go Back")
        }
    }
}
